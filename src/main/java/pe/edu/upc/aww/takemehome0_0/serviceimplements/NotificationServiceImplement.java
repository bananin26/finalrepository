package pe.edu.upc.aww.takemehome0_0.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aww.takemehome0_0.entities.Notification;
import pe.edu.upc.aww.takemehome0_0.repositories.INotificationRepository;
import pe.edu.upc.aww.takemehome0_0.serviceinterfaces.INotificationService;

import java.util.List;

@Service
public class NotificationServiceImplement implements INotificationService {
    @Autowired
    private INotificationRepository nR;
    @Override
    public void insert(Notification notification) {
        nR.save(notification);
    }

    @Override
    public List<Notification> list() {
        return nR.findAll();
    }

    @Override
    public void delete(int idNotification) {
               nR.deleteById(idNotification);
    }
    @Override
    public Notification listId(int idNotification) {
        return nR.findById(idNotification).orElse(new Notification());
    }
}
