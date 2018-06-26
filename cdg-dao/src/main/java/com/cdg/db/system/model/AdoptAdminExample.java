package com.cdg.db.system.model;

import com.cdg.db.plugin.Page;
import java.util.ArrayList;
import java.util.List;

public class AdoptAdminExample {
    /**
     * adopt_admin
     */
    protected String orderByClause;

    /**
     * adopt_admin
     */
    protected boolean distinct;

    /**
     * adopt_admin
     */
    protected List<Criteria> oredCriteria;

    /**
     * adopt_admin
     */
    protected Page page;

    /**
    * auto generate
    * @return null
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    public AdoptAdminExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
    * auto generate
    * @param orderByClause
    * @return null
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
    * auto generate
    * @return java.lang.String
    * @date 2018-01-03 10:35:32
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
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
    * auto generate
    * @return boolean
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
    * auto generate
    * @return java.util.List<Criteria>
    * @date 2018-01-03 10:35:32
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
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
    * auto generate
    * @return Criteria
    * @date 2018-01-03 10:35:32
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
    * @date 2018-01-03 10:35:32
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
    * @date 2018-01-03 10:35:32
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
    * @date 2018-01-03 10:35:32
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
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
    * auto generate
    * @return com.cdg.db.plugin.Page
    * @date 2018-01-03 10:35:32
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

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Long value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Long value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Long value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Long value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Long> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Long> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Long value1, Long value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andWorkAccountIsNull() {
            addCriterion("work_account is null");
            return (Criteria) this;
        }

        public Criteria andWorkAccountIsNotNull() {
            addCriterion("work_account is not null");
            return (Criteria) this;
        }

        public Criteria andWorkAccountEqualTo(String value) {
            addCriterion("work_account =", value, "workAccount");
            return (Criteria) this;
        }

        public Criteria andWorkAccountNotEqualTo(String value) {
            addCriterion("work_account <>", value, "workAccount");
            return (Criteria) this;
        }

        public Criteria andWorkAccountGreaterThan(String value) {
            addCriterion("work_account >", value, "workAccount");
            return (Criteria) this;
        }

        public Criteria andWorkAccountGreaterThanOrEqualTo(String value) {
            addCriterion("work_account >=", value, "workAccount");
            return (Criteria) this;
        }

        public Criteria andWorkAccountLessThan(String value) {
            addCriterion("work_account <", value, "workAccount");
            return (Criteria) this;
        }

        public Criteria andWorkAccountLessThanOrEqualTo(String value) {
            addCriterion("work_account <=", value, "workAccount");
            return (Criteria) this;
        }

        public Criteria andWorkAccountLike(String value) {
            addCriterion("work_account like", value, "workAccount");
            return (Criteria) this;
        }

        public Criteria andWorkAccountNotLike(String value) {
            addCriterion("work_account not like", value, "workAccount");
            return (Criteria) this;
        }

        public Criteria andWorkAccountIn(List<String> values) {
            addCriterion("work_account in", values, "workAccount");
            return (Criteria) this;
        }

        public Criteria andWorkAccountNotIn(List<String> values) {
            addCriterion("work_account not in", values, "workAccount");
            return (Criteria) this;
        }

        public Criteria andWorkAccountBetween(String value1, String value2) {
            addCriterion("work_account between", value1, value2, "workAccount");
            return (Criteria) this;
        }

        public Criteria andWorkAccountNotBetween(String value1, String value2) {
            addCriterion("work_account not between", value1, value2, "workAccount");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andAdminStateIsNull() {
            addCriterion("admin_state is null");
            return (Criteria) this;
        }

        public Criteria andAdminStateIsNotNull() {
            addCriterion("admin_state is not null");
            return (Criteria) this;
        }

        public Criteria andAdminStateEqualTo(Byte value) {
            addCriterion("admin_state =", value, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateNotEqualTo(Byte value) {
            addCriterion("admin_state <>", value, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateGreaterThan(Byte value) {
            addCriterion("admin_state >", value, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("admin_state >=", value, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateLessThan(Byte value) {
            addCriterion("admin_state <", value, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateLessThanOrEqualTo(Byte value) {
            addCriterion("admin_state <=", value, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateIn(List<Byte> values) {
            addCriterion("admin_state in", values, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateNotIn(List<Byte> values) {
            addCriterion("admin_state not in", values, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateBetween(Byte value1, Byte value2) {
            addCriterion("admin_state between", value1, value2, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateNotBetween(Byte value1, Byte value2) {
            addCriterion("admin_state not between", value1, value2, "adminState");
            return (Criteria) this;
        }

        public Criteria andWorkAccountLikeInsensitive(String value) {
            addCriterion("upper(work_account) like", value.toUpperCase(), "workAccount");
            return (Criteria) this;
        }

        public Criteria andPasswordLikeInsensitive(String value) {
            addCriterion("upper(password) like", value.toUpperCase(), "password");
            return (Criteria) this;
        }
    }

    /**
     * adopt_admin
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