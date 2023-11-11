package app.controller;
import app.model.Student;
import app.service.IService;
import app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IService studentService;

    @GetMapping("home")
    public ModelAndView showHome(){
        List<Student> list = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list", list);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }
    @GetMapping("{id}")
    public ModelAndView showForm(@PathVariable int id){
        Student student = (Student) studentService.findStudentById(id);
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("student",student);
        return modelAndView;
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Student student){
        studentService.update(student.getId(),student);
        return "redirect:/students/home";
    }
    @PostMapping("/create")
    public String add(@ModelAttribute Student student){
        studentService.add(student);
        return "redirect:/students/home";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        studentService.delete(id);
        return "redirect:/students/home";
    }
//    @GetMapping("/search")
//    public ModelAndView showSearch(@RequestParam String q){
//        if (q == null){
//            q = "";
//        }
//        List<Student> students = studentService.findByName(q);
//        System.out.println(Arrays.toString(students.toArray()));
//        ModelAndView modelAndView = new ModelAndView("students");
//        modelAndView.addObject("list",students);
//        return modelAndView;
//
//    }
}
