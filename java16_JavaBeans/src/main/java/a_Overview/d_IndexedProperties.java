package a_Overview;
/*
 * Thuộc tính có chỉ số
 *
 * Một thuộc tính có chỉ số bao gồm nhiều giá trị. Nó có thể được xác định bằng các mẫu thiết kế sau,
 * trong đó N là tên của thuộc tính và T là kiểu dữ liệu của nó:
 *
 * public T getN(int index);
 * public void setN(int index, T value);
 * public T[ ] getN();
 * public void setN(T values[]);
 *
 * */

/**
 * Demo
 */
class Demo  {
    private double[] data; // @property data là mảng

    /**
     * @methods getter and setter
     */
    public void setData(double[] value) {
        data = new double[value.length];
        System.arraycopy(data, 0, value, 0, value.length);
    }


    public void setData(int index, double value) {
        data[index] = value;
    }

    public double[] getData () {
        return data;
    }

    public double getData(int index) {
        return data[index];
    }
}


public class d_IndexedProperties {

}
