package app;

/**
 * {@code Sheet}の持つシート情報が変更された時に通知を受け取るリスナー
 * @author Miyaoka
 * @see app.Sheet
 */
public interface SheetListener {
    void sheetChanged();
}
