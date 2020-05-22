package pres.hjc.cloud.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pres.hjc.cloud.entity.Payment;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/10
 * @time 18:55
 */
@Mapper
public interface PaymentMapper {

    /**
     * insert
     * @param payment
     * @return
     */
    @Insert("insert into payment(serial) values (#{serial} ) ;")
    int create(Payment payment);

    /**
     * query by id
     * @param id
     * @return
     */
    @Select("select * from payment where id = #{id} ;")
    Payment getPaymentById (@Param("id") Long id);

    /**
     * query all
     * @return
     */
    @Select("select * from payment")
    List<Payment> queryAll();
}
