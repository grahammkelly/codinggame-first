package com.grahammkelly.blah;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PlayerTest {

  private static final Player cut = new Player(2);


  @ParameterizedTest(name = "checkNearest: {0} @{1} vs. {2}@{3} = {4}")
  @CsvSource({
      "e1, 2, e2, 5, e1",
      "e1, 2, e2, 1, e2"
  })
  public void checkNearest(String e1, int d1, String e2, int d2, String expected) {
    final List<String> incoming = Arrays.asList(e1, String.valueOf(d1), e2, String.valueOf(d2));
    final Iterator<String> iter = incoming.iterator();

    cut.loopAndShoot(iter, enemy -> assertThat(enemy, is(expected)));
  }
}
