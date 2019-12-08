package pl.sdacademy.prog.editor;

import java.util.ArrayDeque;
import java.util.Deque;

public class EditorTextMementoManager {

  private Deque<EditorTextMemento> mementos = new ArrayDeque<>();

  public void save(final EditorTextMemento editorTextMemento) {
    mementos.push(editorTextMemento);
  }

  public EditorTextMemento restore() {
    return mementos.pop();
  }
}
