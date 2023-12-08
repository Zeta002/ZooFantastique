package net.zoofantastique.controller.entity.creature.behavior;

import java.util.Arrays;
import java.util.List;

/**
 * Interface Rank représentant le rang d'une créature.
 */
public interface Rank {
    List<String> greekAlphabet = Arrays.asList(
            "Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota", "Kappa", "Lambda",
            "Mu", "Nu", "Xi", "Omicron", "Pi", "Rho", "Sigma", "Tau", "Upsilon", "Phi", "Chi", "Psi", "Omega"
    );
}
