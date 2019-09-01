package pl.sdacademy.prog.memento;

public class MementoDemo {

  public static void main(String[] args) {
    final EditorText editorText = new EditorText();
    final EditorTextMementoManager manager = new EditorTextMementoManager();

    editorText.add("This is first line");
    manager.save(new EditorTextMemento(editorText));
    editorText.add("This is second line");
    manager.save(new EditorTextMemento(editorText));
    editorText.add("This is fifth line", 5, WriteMode.APPEND);
    manager.save(new EditorTextMemento(editorText));
    editorText.add("This is fourth line", 4, WriteMode.APPEND);
    editorText.add(" fourth line continueation", 4, WriteMode.APPEND);
    manager.save(new EditorTextMemento(editorText));

//    manager.restore();
//    manager.restore();
//    final EditorTextMemento memento = manager.restore();

    //editorText.restoreFromMemento(memento);

    editorText.getEditorTextValue().forEach((k, v) -> System.out.println(k + " " + v));
  }
}
