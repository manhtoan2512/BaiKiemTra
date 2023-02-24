package constant;

public enum ItemsType {

    DIEN_TU("Điện tử"),
    DIEN_LANH("Điện lạnh"),
    MAY_TINH("Máy tính");

    public String value;

    ItemsType(String value) {
        this.value = value;
    }
}
