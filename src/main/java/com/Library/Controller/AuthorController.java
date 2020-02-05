package com.Library.Controller;

import com.Library.Model.Authors;
import com.Library.Services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Authors")
@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    Authors updateAuthor;

    @RequestMapping(value = "/mainAuthorMenu", method = RequestMethod.GET)
    public String mainAuthorMenu(Model model){
        List<Authors> list = authorService.returnAuthors();
        model.addAttribute("allAuthors", list);
        model.addAttribute("newAuthor", new Authors());
        model.addAttribute("deleteAuthor", new Authors());

        return "author/mainAuthorMenu";
    }

    @RequestMapping(value="/addAuthor", method= RequestMethod.POST)
    public ResponseEntity addAuthor(@ModelAttribute Authors author){

        authorService.createNewAuthor(author);

        return ResponseEntity.ok("Автор: id " + author.getAuthorId() + " Name " + author.getFirstName() + " Last name " + author.getLastName() + " успешно создан");
    }

    @GetMapping(value="/deleteAuthor/{authorId}")
    public ResponseEntity deleteAuthor (@PathVariable Integer authorId){
        try {
            authorService.deleteAuthor(authorId);
        }
        catch (Exception e){
            return ResponseEntity.ok("Нельзя удалить автора. Он связан с записью в таблице с книгами/авторами.");
        }
        return  ResponseEntity.ok("Автор c id " + authorId + " успешно удален");
    }

    @GetMapping(value="/updateAuthor1/{authorId}")
    public String updateAuthor1(@PathVariable Integer authorId, Model model){
        updateAuthor = new Authors();
        updateAuthor.setAuthorId(authorId);
        model.addAttribute("updateAuthor", updateAuthor);
        return "author/updateAuthor";
    }

    @RequestMapping(value="/updateAuthor2", method= RequestMethod.POST)
    public ResponseEntity updateAuthor2(@ModelAttribute Authors author){
        updateAuthor.setFirstName(author.getFirstName());
        updateAuthor.setLastName(author.getLastName());
        authorService.modifyAuthor(updateAuthor);
        return ResponseEntity.ok("Автор: id " + updateAuthor.getAuthorId() + " Name " + updateAuthor.getFirstName() + " Last name " + updateAuthor.getLastName() + " успешно создан");
    }

    @RequestMapping(value="/searchAuthor", method= RequestMethod.GET)
    public String searchAuthor(@RequestParam("lastName") String lastName, Model model){
        List<Authors> searchList = authorService.searchAuthor(lastName);
        model.addAttribute("searchAuthors", searchList);
        return "author/searchTheAuthor";
    }
}
