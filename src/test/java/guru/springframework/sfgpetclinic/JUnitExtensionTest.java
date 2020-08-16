package guru.springframework.sfgpetclinic;

import guru.springframework.sfgpetclinic.services.springdatajpa.SpecialitySDJpaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class JUnitExtensionTest {
  @Mock Map<String, Object> mapMock;


  @Test
  void testMock() {
    mapMock.put("Key", 1);
  }
}
