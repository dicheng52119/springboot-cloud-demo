package com.zkhr.elasticjob.repository;

import com.zkhr.elasticjob.domain.Foo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: springboot-cloud-demo
 * @description: FooRepository
 * @author: DI CHENG
 * @create: 2018-01-19 10:49
 **/
@Repository
public class FooRepository {

    private Map<Long,Foo> data = new ConcurrentHashMap<>(300,1);

    public FooRepository() {
        init();
    }

    private void init() {
        addData(0L,100L,"Beijing");
        addData(100L,200L,"Shanghai");
        addData(200L,300L,"Guangzhou");
    }

    private void addData(final Long idFrom,final Long idTo,final String location){
        for(long i=idFrom; i < idTo; i++) {
            data.put(i,new Foo(i,location,Foo.Status.TODO));
        }
    }

    public List<Foo> findTodoData(final String location, final int limit) {
        List<Foo> result = new ArrayList<>(limit);
        int count = 0;
        for (Map.Entry<Long, Foo> each : data.entrySet()) {
            Foo foo = each.getValue();
            if (foo.getLocation().equals(location) && foo.getStatus() == Foo.Status.TODO) {
                result.add(foo);
                count++;
                if (count == limit) {
                    break;
                }
            }
        }
        return result;
    }

    public void setCompleted(final long id) {
        data.get(id).setStatus(Foo.Status.COMPLETED);
    }

}
