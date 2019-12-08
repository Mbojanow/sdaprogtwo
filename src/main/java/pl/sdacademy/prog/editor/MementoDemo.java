package pl.sdacademy.prog.editor;

public class MementoDemo {
  public static void main(String[] args) {
    final EditorText editorText = new EditorText();
    final EditorTextMementoManager mementoManager = new EditorTextMementoManager();


    editorText.addText("Hello this is first line");
    mementoManager.save(new EditorTextMemento(editorText));
    editorText.addText("Hello this is second line");
    mementoManager.save(new EditorTextMemento(editorText));
    editorText.addText("Hello this is third line");
    mementoManager.save(new EditorTextMemento(editorText));
    editorText.addText("This is 6th line", 6, WriteMode.APPEND);
    mementoManager.save(new EditorTextMemento(editorText));
    editorText.addText(". added to third line", 3, WriteMode.APPEND);
    mementoManager.save(new EditorTextMemento(editorText));
    editorText.addText("This is NEW second line", 2, WriteMode.REPLACE);
    mementoManager.save(new EditorTextMemento(editorText));

    editorText.getValue().forEach((k, v) -> System.out.println(k + ": " + v));
    mementoManager.restore();
    mementoManager.restore();
    final EditorTextMemento restoredValue = mementoManager.restore();
    editorText.restoreFromMemento(restoredValue);
    System.out.println();
    editorText.getValue().forEach((k, v) -> System.out.println(k + ": " + v));
  }
}
