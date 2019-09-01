package pl.sdacademy.prog.slack;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // junit
// junit4 @RunWith(MockitoJUnitRunner.class)
class DatabaseStoreTest {

  @Mock
  private DatabaseConnection databaseConnection;

  @InjectMocks
  private DatabaseStore databaseStore;

  @Test
  void shouldOpenDatabaseConnectionAndAddData() {
    // zgodne z intuicja ale NIE DZIAŁA
    //when(databaseConnection.isOpen()).thenReturn(false);
    //when(databaseConnection.isOpen()).thenReturn(true);
    final int[] index = { 0 };
    when(databaseConnection.isOpen()).thenAnswer(invocationOnMock -> {
      if (index[0] == 0) {
        index[0]++;
        return false;
      }
      return true;
    });
    doNothing().when(databaseConnection).open();

    databaseStore.add("asd");

    verify(databaseConnection).open();
    verify(databaseConnection, times(2)).isOpen();
  }

}