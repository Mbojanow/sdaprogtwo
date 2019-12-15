package pl.sdacademy.prog.paczka;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.WillNotClose;

public interface StreamProcessor {
  void process(@WillNotClose InputStream source, @WillNotClose OutputStream sink) throws IOException;
}
