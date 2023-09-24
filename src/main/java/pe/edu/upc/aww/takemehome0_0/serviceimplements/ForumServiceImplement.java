package pe.edu.upc.aww.takemehome0_0.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aww.takemehome0_0.entities.Forum;
import pe.edu.upc.aww.takemehome0_0.repositories.IForumRepository;
import pe.edu.upc.aww.takemehome0_0.serviceinterfaces.IForumService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ForumServiceImplement implements IForumService {

    @Autowired
    private IForumRepository fR;
    @Override
    public void insert(Forum forum) {
        fR.save(forum);
    }

    @Override
    public List<Forum> list() {
        return fR.findAll();
    }

    @Override
    public void delete(int idForum) {
        fR.deleteById(idForum);
    }

    @Override
    public Forum listId(int idForum) {
        return fR.findById(idForum).orElse(new Forum());
    }

    @Override
    public List<Forum> findByDate(LocalDate date) {
        return fR.findByDate(date);
    }
}
