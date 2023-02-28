package cn.billy.jpa;

import cn.billy.beans.BaseEntity;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;


public class JPAListener {




    @PostPersist
    public void createObject(BaseEntity o) {
        //System.out.println("create object :"+ o);
    }


    @PostRemove
    public void removeObject(BaseEntity o) {
        //System.out.println("create object :"+ o);
    }
}
