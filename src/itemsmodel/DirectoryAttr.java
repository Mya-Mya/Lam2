package itemsmodel;

public enum DirectoryAttr {
    Image,
    Title,
    Detail,
    List;

    @Override
    public String toString() {
        switch (this) {
            case Image:
                return "IMAGE";
            case Title:
                return "TITLE";
            case Detail:
                return "DETAIL";
            case List:
                return "LIST";
        }
        return "UNKNOWN";
    }
}
