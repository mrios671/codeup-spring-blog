package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {

    private final Random random = new Random();

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        int diceRoll = random.nextInt(6) + 1;
        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("guess", guess);
        model.addAttribute("message", diceRoll == guess ? "Congratulations! You guessed the correct number." : "Sorry, that's not the correct number. Try again!");
        return "roll-dice";
    }
}