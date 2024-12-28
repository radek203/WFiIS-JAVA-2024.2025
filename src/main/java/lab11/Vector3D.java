package lab11;

import java.util.List;

public class Vector3D<T extends Number> {

    T x;
    T y;
    T z;

    public Vector3D(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public T x() {
        return x;
    }

    public T y() {
        return y;
    }

    public T z() {
        return z;
    }

    public Vector3D<?> add(Vector3D<T> v) {
        if (v.x() instanceof Integer && x instanceof Integer) {
            return new Vector3D<>(v.x().intValue() + x.intValue(), v.y().intValue() + y.intValue(), v.z().intValue() + z.intValue());
        }
        return new Vector3D<>(v.x().doubleValue() + x.doubleValue(), v.y().doubleValue() + y.doubleValue(), v.z().doubleValue() + z.doubleValue());
    }

    public List<T> getList() {
        return List.of(x, y, z);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }

}
