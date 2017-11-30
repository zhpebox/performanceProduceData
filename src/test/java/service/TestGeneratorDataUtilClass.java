package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.performance.dao.TblModuleMapper;
import com.performance.dao.TblModuleRuleMapper;
import com.performance.dao.TblRuleMapper;
import com.performance.generator.util.GeneratorDataUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conftest/spring*.xml"})
public class TestGeneratorDataUtilClass {

	@Autowired
	GeneratorDataUtil generatorDataUtil;

	@Autowired
	TblModuleMapper tblModuleMapper;
	
	@Autowired
	TblModuleRuleMapper tblModuleRuleMapper;
	
	@Autowired
	TblRuleMapper tblRuleMapper;
	
	@Test
	public void TestGeneratorData(){
//		try {
//			TblModule tblModule = tblModuleMapper.selectByPrimaryKey(1);
//			
//			TblModuleRuleExample queryParam = new TblModuleRuleExample();
//			TblModuleRuleExample.Criteria criteria = queryParam.createCriteria();
//			criteria.andModuleKeyEqualTo(1);
//			List<TblModuleRule> ruleLinkList = tblModuleRuleMapper.selectByExample(queryParam);
//			
//			List<TblRule> ruleList = tblRuleMapper.selectByExample(null);
//			HashMap<Integer,TblRule> ruleCache = new HashMap<Integer,TblRule>();
//			for(int i = 0;i<ruleList.size();i++){
//				ruleCache.put(ruleList.get(i).getRuleId(), ruleList.get(i));
//			}
//			
//			HashMap<Integer,TblRule> paramRule = new HashMap<Integer,TblRule>();
//			for(int i = 0;i<ruleLinkList.size();i++){
//				paramRule.put(ruleLinkList.get(i).getParamIndex(), ruleCache.get(ruleLinkList.get(i).getRuleKey()));
//			}
//			
//			Set<Entry<Integer, TblRule>> entrySet = paramRule.entrySet();
//			for(Entry<Integer, TblRule> e : entrySet){
//				System.out.println(e);
//			}
//			GeneratorDataUtil.generatorData(tblModule.getModuleText(), paramRule);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
}
