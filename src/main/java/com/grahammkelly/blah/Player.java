package com.grahammkelly.blah;

import java.util.*;
import java.util.function.Consumer;

class Player {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    new Player().loopAndShoot(in, System.out::println);
  }

  private final int enemiesAtATime;

  public Player(int maxEnemiesAtOnce) {
    enemiesAtATime = maxEnemiesAtOnce;
  }
  public Player() {
    this(2);
  }

  public void loopAndShoot(Iterator<String> in, Consumer<String> consumer) {
    try {
      while (true) {
        consumer.accept(getNearestEnemy(loadEnemiesToAttack(in)));
      }
    } catch (NoSuchElementException ex) {
      System.err.println("Unmatched enemy with distance, quiting");
    }
  }

  private Map<String, Integer> loadEnemiesToAttack(Iterator<String> in) {
    Map<String, Integer> enemies = new HashMap<>();
    for (int i = 0; i < enemiesAtATime; i++) {
      enemies.put(in.next(), Integer.valueOf(in.next()));   //Assuming the values will always be in pairs
    }
    return enemies;
  }

  protected String getNearestEnemy(Map<String, Integer> enemies) {
    return Collections.min(enemies.entrySet(), Map.Entry.comparingByValue()).getKey();
  }
}
