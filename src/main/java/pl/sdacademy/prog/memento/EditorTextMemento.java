package pl.sdacademy.prog.memento;

import java.util.TreeMap;

public class EditorTextMemento {
  private TreeMap<Integer, String> editorTextValue;

  public TreeMap<Integer, String> getEditorTextValue() {
    return editorTextValue;
  }

  public EditorTextMemento(final EditorText editorText) {
    editorTextValue = new TreeMap<>(editorText.getEditorTextValue());
  }
}
