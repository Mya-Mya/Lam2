package itemsmodel;

public enum ProductAttr {
    Entrypt,
    Image,
    Title,
    Productor,
    Detail;

    @Override
    public String toString() {
        switch (this) {
            case Entrypt:
                return "ENTRYPT";
            case Image:
                return "IMAGE";
            case Title:
                return "TITLE";
            case Productor:
                return "PODUCTOR";
            case Detail:
                return "DETAIL";
        }
        return "UNKNOWN";
    }
}
