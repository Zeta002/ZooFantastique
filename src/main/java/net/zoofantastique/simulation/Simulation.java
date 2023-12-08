package net.zoofantastique.simulation;

import net.zoofantastique.controller.enclosure.composition.Enclosure;
import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.view.Game;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Simulation implements Runnable {

    private ScheduledExecutorService executor;
    private Game game;

    public Simulation(Game game) {
        this.executor = Executors.newSingleThreadScheduledExecutor();
        ;
        this.game = game;

        this.run();
    }

    @Override
    public void run() {
        System.out.println("Simulation started");
        executor.scheduleAtFixedRate(() -> {
            for (Enclosure<?> enclosure : game.getZoo().getEnclosures()) {
                for (Creature creature : enclosure.getListCreature()) {
                    if (Objects.equals(creature.getAgeState(), Age.DEAD.getValue())) {
                        enclosure.getListCreature().remove(creature);
                        creature = null;
                    }
                }
            }
        }, 0, 20, TimeUnit.SECONDS);
    }
}

