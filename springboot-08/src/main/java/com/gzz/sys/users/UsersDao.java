package com.gzz.sys.users;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.gzz.common.base.BaseDao;
import com.gzz.common.base.Page;
import com.gzz.common.base.SqlUtil;
/**
 * @类说明 [users]数据访问层
 * @author 高振中
 * @date 2020-01-19 16:43:53
 **/
@Repository
public class UsersDao extends BaseDao{

    private StringBuilder insert = new StringBuilder();
    private StringBuilder select = new StringBuilder();

    /**
     * @方法说明 构造方法-拼加SQL 
     */
    public UsersDao () {
    	select.append("SELECT t.id,t.name,t.age");
    	select.append(" FROM users t WHERE 1=1");
		
        insert.append("INSERT INTO users (name,age) ");
        insert.append(" VALUES (:name,:age)");
    }

    /**
     * @方法说明  新增users记录
     */
    public int save(Users vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO users (id,name,age)");
        sql.append(" VALUES (?,?,?)");
        Object[] params ={ vo.getId(),vo.getName(),vo.getAge() };
        //logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
     * @方法说明 新增users记录并返回自增涨主键值
     */
    public long saveReturnPK(Users vo) {
         return saveKey(vo, insert.toString(), "id");
    }
    
    /**
     * @方法说明 批量插入users记录
     */
    public int[] insertBatch(List<Users> list) {
       return batchOperate(list, insert.toString());
    }
    
    /**
     * @方法说明 物理删除users记录(多条)
     */
    public int delete(Long ids[]) {
        String sql = "DELETE FROM users WHERE id" + SqlUtil.ArrayToIn(ids);
        return jdbcTemplate.update(sql);
    }
    
    /**
     * @方法说明 更新users记录
     */
    public int update(Users vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE users SET name=?,age=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getName(),vo.getAge(),vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
      }

    /**
     * @方法说明 按条件查询分页users列表
     */
    public Page<Users> queryPage(UsersCond cond) {
        StringBuilder sb = new StringBuilder(select);
        sb.append(cond.getCondition());
        //sb.append(cond.getOrderSql());//增加排序子句;
        //logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Users.class);
    }
    
    /**
     * @方法说明 按条件查询不分页users列表
     */
    public List<Users> queryList(UsersCond cond) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(cond.getCondition());
    	//sb.append(" ORDER BY operate_time DESC");
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(Users.class));
    }
    
    /**
     * @方法说明 按ID查找单个users实体
     */
    public Users findById(Long id) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new BeanPropertyRowMapper<>(Users.class));
    }
    
    /**
     * @方法说明 按条件查询users记录个数
     */
    public long queryCount(UsersCond cond) {
    	String countSql = "SELECT COUNT(1) FROM users t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
     * @方法说明 逻辑删除users记录 
     */
    public int deleteLogic(Long ids[]) {
    	String sql = "UPDATE users SET delete_remark=1 WHERE id" + SqlUtil.ArrayToIn(ids);
    	return jdbcTemplate.update(sql);
    }
 
}