package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

  @Mock VisitRepository visitRepository;

  @InjectMocks VisitSDJpaService visitSDJpaService;

  @DisplayName("Test Find All")
  @Test
  void findAll() {
    Visit visit = new Visit();
    Set<Visit> visits = new HashSet<>();
    visits.add(visit);
    Mockito.when(visitRepository.findAll()).thenReturn(visits);
    Set<Visit> foundVisit = visitSDJpaService.findAll();
    Mockito.verify(visitRepository).findAll();
    Assertions.assertThat(foundVisit).hasSize(1);
  }

  @Test
  void findById() {
    Visit visit = new Visit();
    Mockito.when(visitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(visit));
    Visit foundVisit = visitSDJpaService.findById(1l);
    Mockito.verify(visitRepository).findById(Mockito.anyLong());
    Assertions.assertThat(foundVisit).isNotNull();
  }

  @Test
  void save() {
    Visit visit = new Visit();
    Mockito.when(visitRepository.save(Mockito.any(Visit.class))).thenReturn(visit);
    Visit saved = visitSDJpaService.save(new Visit());
    Mockito.verify(visitRepository).save(Mockito.any(Visit.class));
    Assertions.assertThat(saved).isNotNull();
  }

  @Test
  void delete() {
    Visit visit = new Visit();
    visitSDJpaService.delete(visit);
    Mockito.verify(visitRepository).delete(Mockito.any(Visit.class));
  }

  @Test
  void deleteById() {
    visitSDJpaService.deleteById(1l);
    Mockito.verify(visitRepository).deleteById(Mockito.anyLong());
  }
}
