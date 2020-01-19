package com.gzz.sys.blacklist;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.gzz.common.base.BaseDao;
import com.gzz.common.base.Page;
import com.gzz.common.base.SqlUtil;
/**
 * @类说明 [blacklist]数据访问层
 * @author 高振中
 * @date 2020-01-19 16:43:53
 **/
@Repository
public class BlacklistDao extends BaseDao{

    private StringBuilder insert = new StringBuilder();
    private StringBuilder select = new StringBuilder();

    /**
     * @方法说明 构造方法-拼加SQL 
     */
    public BlacklistDao () {
    	select.append("SELECT t.id,t.ip,t.iptime");
    	select.append(" FROM blacklist t WHERE 1=1");
		
        insert.append("INSERT INTO blacklist (ip,iptime) ");
        insert.append(" VALUES (:ip,:iptime)");
    }

    /**
     * @方法说明  新增blacklist记录
     */
    public int save(Blacklist vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO blacklist (id,ip,iptime)");
        sql.append(" VALUES (?,?,?)");
        Object[] params ={ vo.getId(),vo.getIp(),vo.getIptime() };
        //logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
     * @方法说明 新增blacklist记录并返回自增涨主键值
     */
    public long saveReturnPK(Blacklist vo) {
         return saveKey(vo, insert.toString(), "id");
    }
    
    /**
     * @方法说明 批量插入blacklist记录
     */
    public int[] insertBatch(List<Blacklist> list) {
       return batchOperate(list, insert.toString());
    }
    
    /**
     * @方法说明 物理删除blacklist记录(多条)
     */
    public int delete(Integer ids[]) {
        String sql = "DELETE FROM blacklist WHERE id" + SqlUtil.ArrayToIn(ids);
        return jdbcTemplate.update(sql);
    }
    
    /**
     * @方法说明 更新blacklist记录
     */
    public int update(Blacklist vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE blacklist SET ip=?,iptime=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getIp(),vo.getIptime(),vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
      }

    /**
     * @方法说明 按条件查询分页blacklist列表
     */
    public Page<Blacklist> queryPage(BlacklistCond cond) {
        StringBuilder sb = new StringBuilder(select);
        sb.append(cond.getCondition());
        //sb.append(cond.getOrderSql());//增加排序子句;
        //logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Blacklist.class);
    }
    
    /**
     * @方法说明 按条件查询不分页blacklist列表
     */
    public List<Blacklist> queryList(BlacklistCond cond) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(cond.getCondition());
    	//sb.append(" ORDER BY operate_time DESC");
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(Blacklist.class));
    }
    
    /**
     * @方法说明 按ID查找单个blacklist实体
     */
    public Blacklist findById(Integer id) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new BeanPropertyRowMapper<>(Blacklist.class));
    }
    
    /**
     * @方法说明 按条件查询blacklist记录个数
     */
    public long queryCount(BlacklistCond cond) {
    	String countSql = "SELECT COUNT(1) FROM blacklist t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
     * @方法说明 逻辑删除blacklist记录 
     */
    public int deleteLogic(Integer ids[]) {
    	String sql = "UPDATE blacklist SET delete_remark=1 WHERE id" + SqlUtil.ArrayToIn(ids);
    	return jdbcTemplate.update(sql);
    }
 
}