package c_Example;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.*;
import java.io.Serializable;

/*
 * Một ví dụ về Bean
 * Chương này kết thúc bằng một ví dụ minh họa các khía cạnh khác nhau của lập trình Bean,
 * bao gồm thẩm định và sử dụng một lớp BeanInfo. Nó cũng sử dụng các lớp Introspector,
 * PropertyDescriptor và EventSetDescriptor. Ví dụ này sử dụng ba lớp.
 *
 * Lớp đầu tiên là một Bean được gọi là Colors, được hiển thị dưới đây.
 * */


class Colors extends Canvas implements Serializable {
    transient private Color color; // không bền vững (không được lưu trữ lâu dài)
    private boolean rectangular; // bền vững
    //rectangular : hình chữ nhật

    /**
     * @contructor
     * @param : no
     */
    public Colors () {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                change(); // khi nhấn chuột thì màu sắc sẽ thay đổi random
            }
        });
        rectangular = false;
        setSize(200, 100);
        change();
    }

    public boolean getRectangular() {
        return rectangular;
    }

    // trong lập trình thuật ngữ flag được thể hiện là một sự đánh dấu
    // hoặc flag variable : biến đánh dấu
    public void setRectangular(boolean flag) {
        this.rectangular = flag;
        repaint();
    }

    public void change() {
        color = randomColor();
        repaint();
    }

    private Color randomColor() {
        int r = (int) (255 * Math.random()); // random từ 0 - 254
        int g = (int) (255 * Math.random());
        int b = (int) (255 * Math.random());
        return new Color(r, g, b);
    }

    @Override
    public void paint(Graphics g) {
        Dimension d = getSize();
        int h = d.height;
        int w = d.width;

        g.setColor(color);
        if(rectangular)
            g.fillRect(0, 0, w-1, h-1);
        else
            g.fillOval(0, 0, w-1, h-1);
    }
}

/*
 * Lớp Colors Bean hiển thị một đối tượng có màu sắc trong một khung.
 * Màu sắc của thành phần được xác định bởi biến private Color color,
 * và hình dạng của nó được xác định bởi biến boolean private rectangular.
 * Constructor định nghĩa một lớp inner class ẩn danh mở rộng từ MouseAdapter
 * và ghi đè phương thức mousePressed(). Phương thức change() được gọi khi
 * nhấn chuột. Nó chọn một màu ngẫu nhiên và sau đó vẽ lại thành phần.
 * Các phương thức getRectangular() và setRectangular() cung cấp quyền
 * truy cập vào thuộc tính của Bean này. Phương thức change() gọi
 * randomColor() để chọn một màu và sau đó gọi repaint() để hiển thị
 * sự thay đổi. Lưu ý rằng phương thức paint() sử dụng các biến rectangular
 * và color để xác định cách trình bày Bean.
 *
 * */

/*
 * Lớp tiếp theo là ColorsBeanInfo. Đây là một lớp con của SimpleBeanInfo
 * cung cấp thông tin rõ ràng về Colors. Nó ghi đè phương thức getPropertyDescriptors()
 * để chỉ định các thuộc tính nào được trình bày cho người sử dụng Bean.
 * Trong trường hợp này, chỉ có thuộc tính rectangular được tiết lộ.
 * Phương thức tạo và trả về một đối tượng PropertyDescriptor cho
 * thuộc tính rectangular. Đây là constructor PropertyDescriptor được sử dụng:
 *
 * PropertyDescriptor(String property, Class<?> beanCls) throws IntrospectionException
 *
 * Ở đây, đối số đầu tiên là tên của thuộc tính, và đối số thứ hai là lớp của Bean.
 * */
class ColorsBeanInfo extends SimpleBeanInfo {
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor rectangular = new
                    PropertyDescriptor("rectangular", Colors.class);
            PropertyDescriptor pd[] = {rectangular};
            return pd;
        }catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}

/*
 * Lớp cuối cùng được gọi là IntrospectorDemo. Nó sử dụng introspection
 * để hiển thị các thuộc tính và sự kiện có sẵn trong Colors Bean.
 * */

class IntrospectorDemo {
    public static void main(String[] args) {
        try {
//            Class<?> c = Class.forName("c_Example.Colors");
            BeanInfo beanInfo = new ColorsBeanInfo();

            // Hiển thị các thuộc tính
            System.out.println("Properties: ");
            PropertyDescriptor propertyDescriptor[] =
                    beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptor.length; i++) {
                System.out.println("\t" + propertyDescriptor[i].getName());
            }

            // Hiển thị các event
            System.out.println("Event: ");
            EventSetDescriptor eventSetDescriptor[] = beanInfo.getEventSetDescriptors();
            for (int i = 0; i < eventSetDescriptor.length; i++) {
                System.out.println("\t" + eventSetDescriptor[i].getName());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


/*
* Chú ý hai điều trong đầu ra. Đầu tiên, vì ColorsBeanInfo ghi đè phương thức getPropertyDescriptors()
* sao cho chỉ có thuộc tính rectangular được trả về, chỉ thuộc tính rectangular được hiển thị.
* Tuy nhiên, vì phương thức getEventSetDescriptors() không được ghi đè bởi ColorsBeanInfo,
* quá trình introspection theo mô hình thiết kế được sử dụng và tất cả các sự kiện được tìm thấy,
* bao gồm cả những sự kiện trong lớp cha của Colors, là Canvas. Hãy nhớ rằng nếu bạn không ghi đè
* một trong các phương thức "get" được định nghĩa bởi SimpleBeanInfo, thì mặc định, quá trình introspection
* theo mô hình thiết kế được sử dụng.
*
* Để quan sát sự khác biệt mà ColorsBeanInfo tạo ra, xóa tệp tin của nó và chạy lại IntrospectorDemo.
* Lần này nó sẽ báo cáo nhiều thuộc tính hơn.
* */
