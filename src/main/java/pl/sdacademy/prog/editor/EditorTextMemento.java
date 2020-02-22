package pl.sdacademy.prog.editor;

import java.util.TreeMap;

public class EditorTextMemento {
  private TreeMap<Integer, String> savedEditorTextValues;

  public EditorTextMemento(final EditorText editorText) {
    // deep copy, nie shallow copy
    this.savedEditorTextValues = new TreeMap<>(editorText.getEditorTextValues());
  }

  public TreeMap<Integer, String> getSavedEditorTextValues() {
    return savedEditorTextValues;
  }
}
