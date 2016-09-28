package demo.me.mydemoapplication.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by zjchai on 16/9/26.
 */
@Builder
public class Student {

    private String name ;
    private String id ;
    private String school ;
    private String gender ;

}
