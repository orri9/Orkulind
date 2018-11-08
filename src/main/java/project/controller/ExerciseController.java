package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Exercise;
import project.service.ExerciseService;

@Controller
public class ExerciseController {

    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @RequestMapping(value = "/exercises", method = RequestMethod.GET)
    public String createExViewGet(Model model){

        model.addAttribute("exercise",new Exercise());

         model.addAttribute("exercises", exerciseService.findAllExercisesReverseOrder());

        return "Exercises";
    }

    @RequestMapping(value = "/ex", method = RequestMethod.POST)
    public String exerciseViewPost(@ModelAttribute("exercise") Exercise exercise,
                                     Model model){

        exerciseService.save(exercise);

        model.addAttribute("exercises", exerciseService.findAllExercisesReverseOrder());

        model.addAttribute("exercise", new Exercise());

        return "Exercises";
    }

}
