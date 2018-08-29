package edu.vt.cs4604.troop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class ScoutController {
  private ScoutRepository repository;

  public ScoutController(ScoutRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/scouts")
  public Collection<Scout> scouts() {
    return repository.findAll().stream()
      .collect(Collectors.toList());
  }
  @PostMapping("/scouts")
  public Scout addScout(Scout scout) {
    System.out.println(scout.toString());
    return repository.save(scout);
  }

  @PostMapping("/deleteScout")
  public Scout deleteScout(Long scoutId) {
    Scout = repository.findById(scoutId);
    repository.deleteScout(scoutId);
  }
}
