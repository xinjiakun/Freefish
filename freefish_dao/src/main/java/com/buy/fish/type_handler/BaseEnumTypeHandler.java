//package com.buy.fish.type_handler;
//
//import com.jdjr.risk.bean.enums.*;
//import com.jdjr.risk.bean.enums.pop_base_enum.CreateWayEnum;
//import com.jdjr.risk.bean.enums.pop_base_enum.HandleResultEnum;
//import com.jdjr.risk.bean.enums.pop_base_enum.HandleStatusEnum;
//import com.jdjr.risk.bean.enums.pop_base_enum.ProblemTypeEnum;
//import com.jdjr.risk.bean.enums.util.EnumUtil;
//import org.apache.ibatis.type.BaseTypeHandler;
//import org.apache.ibatis.type.JdbcType;
//import org.apache.ibatis.type.MappedJdbcTypes;
//import org.apache.ibatis.type.MappedTypes;
//
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// * BaseEnum及其子类的枚举类都会使用该枚举类型处理器
// */
//@MappedJdbcTypes(JdbcType.INTEGER)
//@MappedTypes({ProblemTypeEnum.class, CreateWayEnum.class, HandleResultEnum.class, HandleStatusEnum.class, BaseEnum.class})
//public class BaseEnumTypeHandler<E extends Enum<?> & BaseEnum> extends BaseTypeHandler<BaseEnum> {
//
//    private Class<E> type;
//
//    //必须要有无参构造方法，否则不起作用
//    public BaseEnumTypeHandler() {
//    }
//
//    public BaseEnumTypeHandler(Class<E> type) {
//        if (type == null) {
//            throw new IllegalArgumentException("Type argument cannot be null");
//        }
//        this.type = type;
//    }
//
//    @Override
//    public void setNonNullParameter(PreparedStatement ps, int i, BaseEnum parameter, JdbcType jdbcType) throws SQLException {
//        ps.setInt(i, parameter.getCode());
//    }
//
//    @Override
//    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
//        int code = rs.getInt(columnName);
//        return rs.wasNull() ? null : EnumUtil.getEnumByCode(type, code);
//    }
//
//    @Override
//    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
//        int code = rs.getInt(columnIndex);
//        return rs.wasNull() ? null : EnumUtil.getEnumByCode(type, code);
//    }
//
//    @Override
//    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
//        int code = cs.getInt(columnIndex);
//        return cs.wasNull() ? null : EnumUtil.getEnumByCode(type, code);
//    }
//
//}
