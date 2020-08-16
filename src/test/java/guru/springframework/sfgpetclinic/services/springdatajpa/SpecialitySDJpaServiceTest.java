package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

  @Mock SpecialtyRepository specialtyRepository;

  @InjectMocks SpecialitySDJpaService specialitySDJpaService;

  @Test
  void findByIdBDDTest() {
    Speciality speciality = new Speciality();
    given(specialtyRepository.findById(1l)).willReturn(Optional.of(speciality));
  }

  @Test
  void testDeleteByObject() {
    Speciality speciality = new Speciality();
    specialitySDJpaService.delete(speciality);

    Mockito.verify(specialtyRepository).delete(Mockito.any(Speciality.class));
  }

  @Test
  void deleteById() {
    specialitySDJpaService.deleteById(1l);
    specialitySDJpaService.deleteById(1l);

    Mockito.verify(specialtyRepository, Mockito.times(2)).deleteById(1l);
  }

  @Test
  void deleteByIdAtleastOnce() {
    specialitySDJpaService.deleteById(1l);
    specialitySDJpaService.deleteById(1l);

    Mockito.verify(specialtyRepository, Mockito.atLeastOnce()).deleteById(1l);
  }

  @Test
  void deleteByIdAtmost() {
    specialitySDJpaService.deleteById(1l);
    specialitySDJpaService.deleteById(1l);

    Mockito.verify(specialtyRepository, Mockito.atMost(2)).deleteById(1l);
  }

  @Test
  void deleteByIdNever() {
    specialitySDJpaService.deleteById(1l);
    specialitySDJpaService.deleteById(1l);

    Mockito.verify(specialtyRepository, Mockito.atLeastOnce()).deleteById(1l);
    Mockito.verify(specialtyRepository, Mockito.never()).deleteById(1l);
  }

  @Test
  void testDelete() {
    specialitySDJpaService.delete(new Speciality());
  }

  @Test
  void testDoThrow() {
    Mockito.doThrow(new RuntimeException("Boom")).when(specialtyRepository).delete(any());
    org.junit.jupiter.api.Assertions.assertThrows(
        RuntimeException.class, () -> specialitySDJpaService.delete(new Speciality()));
    Mockito.verify(specialtyRepository).delete(Mockito.any(Speciality.class));
  }

  @Test
  void testFindById() {
    Mockito.doThrow(new RuntimeException("Hello")).when((specialtyRepository)).findById(anyLong());
    Assertions.assertThrows(RuntimeException.class, () -> specialitySDJpaService.findById(1l));
    Mockito.verify(specialtyRepository).findById(anyLong());
  }
  
  
}
