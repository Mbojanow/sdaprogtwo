package pl.sdacademy.prog.memento;

import java.util.TreeMap;

public class EditorText {
  private TreeMap<Integer, String> editorTextValue = new TreeMap<>();

  public TreeMap<Integer, String> getEditorTextValue() {
    return editorTextValue;
  }

  public void add(final String text) {
    final int actualSize = editorTextValue.size();
    editorTextValue.put(actualSize + 1, text);
  }

  public void add(final String text, final int lineNum, final WriteMode mode) {
    if (lineNum <= 0) {
      // idealnie - wyrzucac wyjatek własnego typu
      throw new RuntimeException("Line number has to be positive");
    }

    final int actualSize = editorTextValue.size();
    if (actualSize < lineNum) {
      addNonExistingLine(lineNum, actualSize, text);
    } else {
      modifyExistingLine(mode, text, lineNum);
    }
  }

  private void addNonExistingLine(final int lineNum, final int actualSize, final String text) {
    final int emptyLinesNumToAdd = lineNum - actualSize - 1;
    for (int idx = actualSize + 1; idx <= actualSize + emptyLinesNumToAdd; idx++) {
      editorTextValue.put(idx, "");
    }
    editorTextValue.put(lineNum, text);
  }

  private void modifyExistingLine(final WriteMode mode, final String text, final int lineNum) {
    String newLineContent;
    if (mode == WriteMode.REPLACE) {
      newLineContent = text;
    } else if (mode == WriteMode.APPEND) {
      newLineContent = editorTextValue.get(lineNum) + text;
    } else {
      throw new RuntimeException("Unsupported WriteMode");
    }
    editorTextValue.put(lineNum, newLineContent);
  }

  public void restoreFromMemento(final EditorTextMemento memento) {
    this.editorTextValue = new TreeMap<>(memento.getEditorTextValue());
  }
}
