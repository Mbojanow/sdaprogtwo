package pl.sdacademy.prog.editor;

import java.util.ArrayDeque;
import java.util.Deque;

public class EditorTextMementoManager {

  // deque jako stos!
  private Deque<EditorTextMemento> mementos = new ArrayDeque<>();

  public void addMemento(final EditorTextMemento memento) {
    mementos.push(memento);
  }

  public EditorTextMemento restore() {
    return mementos.pop();
  }
}
