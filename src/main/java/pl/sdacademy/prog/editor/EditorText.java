package pl.sdacademy.prog.editor;

import java.util.TreeMap;

import pl.sdacademy.prog.streams.SdaException;

public class EditorText {

  private TreeMap<Integer, String> editorTextValues = new TreeMap<>();

  public TreeMap<Integer, String> getEditorTextValues() {
    return editorTextValues;
  }

  public void addText(final String textToAdd) {
    final int newLineIndex = editorTextValues.size() + 1;
    editorTextValues.put(newLineIndex, textToAdd);
  }

  public void addText(final String textToAdd, final int lineNum, final WriteMode writeMode) {
    validateLineNum(lineNum);
    if (lineNum > editorTextValues.size()) {
      handleNewLineCreation(lineNum, textToAdd);
    } else {
      handleExistingLineEdit(textToAdd, lineNum, writeMode);
    }
  }

  private void validateLineNum(final int lineNum) {
    if (lineNum <= 0) {
      throw new SdaException("Line number has to be positive number");
    }
  }

  private void handleNewLineCreation(final int lineNum, final String textToAdd) {
    //      final int linesNumToAdd = lineNum - editorTextValues.size() - 1;
//      for (int i = 0; i < linesNumToAdd; i++) {
//        editorTextValues.put(editorTextValues.size() + 1 + i, "");
//      }
    for (int idx = editorTextValues.size() + 1; idx < lineNum; idx++) {
      editorTextValues.put(idx, "");
    }
    editorTextValues.put(lineNum, textToAdd);
  }

  private void handleExistingLineEdit(final String textToAdd, final int lineNum,
                                      final WriteMode writeMode) {
    if (writeMode == WriteMode.APPEND) {
      editorTextValues.replace(lineNum, editorTextValues.get(lineNum) + textToAdd);
    } else if (writeMode == WriteMode.REPLACE) {
      editorTextValues.replace(lineNum, textToAdd);
    }
  }

  public void restoreFromMemento(final EditorTextMemento memento) {
    editorTextValues = new TreeMap<>(memento.getSavedEditorTextValues());
  }
}
