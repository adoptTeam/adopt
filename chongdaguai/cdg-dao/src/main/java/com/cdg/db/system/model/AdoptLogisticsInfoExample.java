package com.cdg.db.system.model;

import com.cdg.db.plugin.Page;
import java.util.ArrayList;
import java.util.List;

public class AdoptLogisticsInfoExample {
    /**
     * adopt_logistics_info
     */
    protected String orderByClause;

    /**
     * adopt_logistics_info
     */
    protected boolean distinct;

    /**
     * adopt_logistics_info
     */
    protected List<Criteria> oredCriteria;

    /**
     * adopt_logistics_info
     */
    protected Page page;

    /**
    * auto generate
    * @return null
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    public AdoptLogisticsInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
    * auto generate
    * @param orderByClause
    * @return null
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
    * auto generate
    * @return java.lang.String
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
    * auto generate
    * @param distinct
    * @return null
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
    * auto generate
    * @return boolean
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
    * auto generate
    * @return java.util.List<Criteria>
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
    * auto generate
    * @param criteria
    * @return null
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
    * auto generate
    * @return Criteria
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
    * auto generate
    * @return Criteria
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
    * auto generate
    * @return Criteria
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
    * auto generate
    * @return null
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
    * auto generate
    * @param page
    * @return null
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
    * auto generate
    * @return com.cdg.db.plugin.Page
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    public Page getPage() {
        return page;
    }

    /**
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLogisticsIdIsNull() {
            addCriterion("logistics_id is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIsNotNull() {
            addCriterion("logistics_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdEqualTo(Long value) {
            addCriterion("logistics_id =", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotEqualTo(Long value) {
            addCriterion("logistics_id <>", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThan(Long value) {
            addCriterion("logistics_id >", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("logistics_id >=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThan(Long value) {
            addCriterion("logistics_id <", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThanOrEqualTo(Long value) {
            addCriterion("logistics_id <=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIn(List<Long> values) {
            addCriterion("logistics_id in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotIn(List<Long> values) {
            addCriterion("logistics_id not in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdBetween(Long value1, Long value2) {
            addCriterion("logistics_id between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotBetween(Long value1, Long value2) {
            addCriterion("logistics_id not between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdIsNull() {
            addCriterion("adopt_id is null");
            return (Criteria) this;
        }

        public Criteria andAdoptIdIsNotNull() {
            addCriterion("adopt_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdoptIdEqualTo(Long value) {
            addCriterion("adopt_id =", value, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdNotEqualTo(Long value) {
            addCriterion("adopt_id <>", value, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdGreaterThan(Long value) {
            addCriterion("adopt_id >", value, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdGreaterThanOrEqualTo(Long value) {
            addCriterion("adopt_id >=", value, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdLessThan(Long value) {
            addCriterion("adopt_id <", value, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdLessThanOrEqualTo(Long value) {
            addCriterion("adopt_id <=", value, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdIn(List<Long> values) {
            addCriterion("adopt_id in", values, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdNotIn(List<Long> values) {
            addCriterion("adopt_id not in", values, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdBetween(Long value1, Long value2) {
            addCriterion("adopt_id between", value1, value2, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdNotBetween(Long value1, Long value2) {
            addCriterion("adopt_id not between", value1, value2, "adoptId");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentIsNull() {
            addCriterion("logistics_content is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentIsNotNull() {
            addCriterion("logistics_content is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentEqualTo(String value) {
            addCriterion("logistics_content =", value, "logisticsContent");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentNotEqualTo(String value) {
            addCriterion("logistics_content <>", value, "logisticsContent");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentGreaterThan(String value) {
            addCriterion("logistics_content >", value, "logisticsContent");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_content >=", value, "logisticsContent");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentLessThan(String value) {
            addCriterion("logistics_content <", value, "logisticsContent");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentLessThanOrEqualTo(String value) {
            addCriterion("logistics_content <=", value, "logisticsContent");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentLike(String value) {
            addCriterion("logistics_content like", value, "logisticsContent");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentNotLike(String value) {
            addCriterion("logistics_content not like", value, "logisticsContent");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentIn(List<String> values) {
            addCriterion("logistics_content in", values, "logisticsContent");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentNotIn(List<String> values) {
            addCriterion("logistics_content not in", values, "logisticsContent");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentBetween(String value1, String value2) {
            addCriterion("logistics_content between", value1, value2, "logisticsContent");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentNotBetween(String value1, String value2) {
            addCriterion("logistics_content not between", value1, value2, "logisticsContent");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsContentLikeInsensitive(String value) {
            addCriterion("upper(logistics_content) like", value.toUpperCase(), "logisticsContent");
            return (Criteria) this;
        }
    }

    /**
     * adopt_logistics_info
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}