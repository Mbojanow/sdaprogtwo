package pl.sdacademy.prog.editor;

public class EditorDemo {
  public static void main(String[] args) {
    final EditorTextMementoManager mementoManager = new EditorTextMementoManager();
    final EditorText editorText = new EditorText();
    mementoManager.addMemento(new EditorTextMemento(editorText));

    editorText.addText("This should be first line");
    mementoManager.addMemento(new EditorTextMemento(editorText));

    editorText.addText("This should be second line");
    mementoManager.addMemento(new EditorTextMemento(editorText));

    editorText.addText("This should be fifth line", 5, WriteMode.APPEND);
    mementoManager.addMemento(new EditorTextMemento(editorText));

    editorText.addText("This is new 3rd line", 3, WriteMode.APPEND);
    mementoManager.addMemento(new EditorTextMemento(editorText));

    editorText.addText(" This is third line addition", 3 ,WriteMode.APPEND);
    mementoManager.addMemento(new EditorTextMemento(editorText));

    editorText.getEditorTextValues().forEach((k, v) -> System.out.println(k + ": " + v));

    //ctrl + z
    mementoManager.restore();
    //ctrl + z
    mementoManager.restore();
    //ctrl + z
    mementoManager.restore();
    //ctrl + z
    final EditorTextMemento memento = mementoManager.restore();
    editorText.restoreFromMemento(memento);

    System.out.println();
    editorText.getEditorTextValues().forEach((k, v) -> System.out.println(k + ": " + v));
  }
}
