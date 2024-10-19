package org.example.jdbcexamples.repository;

import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dto.AddressUser;
import org.example.jdbcexamples.dto.UserAddress;
import org.example.jdbcexamples.mapper.AddressUserRowMapper;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.jdbcexamples.mapper.UserAddressResultSetExtractor;
import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {


    //查询通过UserId
    List<Address> findByUserId(String uid);

    //基于userid查询address信息
    @Query("""
            select a.create_time and a.detail and a.user_id and a.create_time and a.update_time
            from address a join user u on u.id = a.user_id
            where a.id=:aid
            """)
    AddressUser findAddressUserById(String aid);


    @Modifying
    @Query("""
            update address a set a.detail=:detail where a.id=:id
            """)
    void updateDetail(String detail, String id);



    //更新数据
    @Modifying
    @Query("""
            update address a set a.detail=:detail where a.user_id=:id
            """)
    void updateDetailUser(String detail, String id);

    //基于addressId查询address信息和全部user信息
    @Query(value = "select * from address a,user u where a.user_id=u.id and a.id=:aid",
            rowMapperClass = AddressUserRowMapper.class)
    AddressUser findAddressUserById1(String aid);

    @Query(value = "select * from address a,user u where u.id=:uid and a.user_id = u.id",
            resultSetExtractorClass = UserAddressResultSetExtractor.class
    )
    UserAddress findUserAddress(String uid);

}
