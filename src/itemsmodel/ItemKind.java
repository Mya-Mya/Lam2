package itemsmodel;

public enum ItemKind {
    DIRECTORY,
    PRODUCT;

    public char getSign() {
        switch (this) {
            case DIRECTORY:
                return 'd';
            case PRODUCT:
                return 'p';
        }
        return '0';
    }

    @Override
    public String toString() {
        switch (this) {
            case DIRECTORY:
                return "Directory";
            case PRODUCT:
                return "Product";
        }
        return "Unknown";
    }
}
