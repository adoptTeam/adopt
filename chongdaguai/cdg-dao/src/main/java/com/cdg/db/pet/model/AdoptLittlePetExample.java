package com.cdg.db.pet.model;

import com.cdg.db.plugin.Page;
import java.util.ArrayList;
import java.util.List;

public class AdoptLittlePetExample {
    /**
     * adopt_little_ped
     */
    protected String orderByClause;

    /**
     * adopt_little_ped
     */
    protected boolean distinct;

    /**
     * adopt_little_ped
     */
    protected List<Criteria> oredCriteria;

    /**
     * adopt_little_ped
     */
    protected Page page;

    /**
    * auto generate
    * @return null
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    public AdoptLittlePetExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
    * auto generate
    * @param orderByClause
    * @return null
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
    * auto generate
    * @return java.lang.String
    * @date 2018-01-08 18:12:20
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
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
    * auto generate
    * @return boolean
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
    * auto generate
    * @return java.util.List<Criteria>
    * @date 2018-01-08 18:12:20
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
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
    * auto generate
    * @return Criteria
    * @date 2018-01-08 18:12:20
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
    * @date 2018-01-08 18:12:20
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
    * @date 2018-01-08 18:12:20
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
    * @date 2018-01-08 18:12:20
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
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
    * auto generate
    * @return com.cdg.db.plugin.Page
    * @date 2018-01-08 18:12:20
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

        public Criteria andPetIdIsNull() {
            addCriterion("pet_id is null");
            return (Criteria) this;
        }

        public Criteria andPetIdIsNotNull() {
            addCriterion("pet_id is not null");
            return (Criteria) this;
        }

        public Criteria andPetIdEqualTo(Long value) {
            addCriterion("pet_id =", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotEqualTo(Long value) {
            addCriterion("pet_id <>", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdGreaterThan(Long value) {
            addCriterion("pet_id >", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pet_id >=", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdLessThan(Long value) {
            addCriterion("pet_id <", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdLessThanOrEqualTo(Long value) {
            addCriterion("pet_id <=", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdIn(List<Long> values) {
            addCriterion("pet_id in", values, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotIn(List<Long> values) {
            addCriterion("pet_id not in", values, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdBetween(Long value1, Long value2) {
            addCriterion("pet_id between", value1, value2, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotBetween(Long value1, Long value2) {
            addCriterion("pet_id not between", value1, value2, "petId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Byte value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Byte value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Byte value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Byte value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Byte value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Byte> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Byte> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Byte value1, Byte value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Byte value1, Byte value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Long value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Long value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Long value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Long value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Long value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Long value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Long> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Long> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Long value1, Long value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Long value1, Long value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBreedIsNull() {
            addCriterion("breed is null");
            return (Criteria) this;
        }

        public Criteria andBreedIsNotNull() {
            addCriterion("breed is not null");
            return (Criteria) this;
        }

        public Criteria andBreedEqualTo(String value) {
            addCriterion("breed =", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedNotEqualTo(String value) {
            addCriterion("breed <>", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedGreaterThan(String value) {
            addCriterion("breed >", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedGreaterThanOrEqualTo(String value) {
            addCriterion("breed >=", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedLessThan(String value) {
            addCriterion("breed <", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedLessThanOrEqualTo(String value) {
            addCriterion("breed <=", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedLike(String value) {
            addCriterion("breed like", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedNotLike(String value) {
            addCriterion("breed not like", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedIn(List<String> values) {
            addCriterion("breed in", values, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedNotIn(List<String> values) {
            addCriterion("breed not in", values, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedBetween(String value1, String value2) {
            addCriterion("breed between", value1, value2, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedNotBetween(String value1, String value2) {
            addCriterion("breed not between", value1, value2, "breed");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andBirthControlIsNull() {
            addCriterion("birth_control is null");
            return (Criteria) this;
        }

        public Criteria andBirthControlIsNotNull() {
            addCriterion("birth_control is not null");
            return (Criteria) this;
        }

        public Criteria andBirthControlEqualTo(Byte value) {
            addCriterion("birth_control =", value, "birthControl");
            return (Criteria) this;
        }

        public Criteria andBirthControlNotEqualTo(Byte value) {
            addCriterion("birth_control <>", value, "birthControl");
            return (Criteria) this;
        }

        public Criteria andBirthControlGreaterThan(Byte value) {
            addCriterion("birth_control >", value, "birthControl");
            return (Criteria) this;
        }

        public Criteria andBirthControlGreaterThanOrEqualTo(Byte value) {
            addCriterion("birth_control >=", value, "birthControl");
            return (Criteria) this;
        }

        public Criteria andBirthControlLessThan(Byte value) {
            addCriterion("birth_control <", value, "birthControl");
            return (Criteria) this;
        }

        public Criteria andBirthControlLessThanOrEqualTo(Byte value) {
            addCriterion("birth_control <=", value, "birthControl");
            return (Criteria) this;
        }

        public Criteria andBirthControlIn(List<Byte> values) {
            addCriterion("birth_control in", values, "birthControl");
            return (Criteria) this;
        }

        public Criteria andBirthControlNotIn(List<Byte> values) {
            addCriterion("birth_control not in", values, "birthControl");
            return (Criteria) this;
        }

        public Criteria andBirthControlBetween(Byte value1, Byte value2) {
            addCriterion("birth_control between", value1, value2, "birthControl");
            return (Criteria) this;
        }

        public Criteria andBirthControlNotBetween(Byte value1, Byte value2) {
            addCriterion("birth_control not between", value1, value2, "birthControl");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andVaccineTimeIsNull() {
            addCriterion("vaccine_time is null");
            return (Criteria) this;
        }

        public Criteria andVaccineTimeIsNotNull() {
            addCriterion("vaccine_time is not null");
            return (Criteria) this;
        }

        public Criteria andVaccineTimeEqualTo(Long value) {
            addCriterion("vaccine_time =", value, "vaccineTime");
            return (Criteria) this;
        }

        public Criteria andVaccineTimeNotEqualTo(Long value) {
            addCriterion("vaccine_time <>", value, "vaccineTime");
            return (Criteria) this;
        }

        public Criteria andVaccineTimeGreaterThan(Long value) {
            addCriterion("vaccine_time >", value, "vaccineTime");
            return (Criteria) this;
        }

        public Criteria andVaccineTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("vaccine_time >=", value, "vaccineTime");
            return (Criteria) this;
        }

        public Criteria andVaccineTimeLessThan(Long value) {
            addCriterion("vaccine_time <", value, "vaccineTime");
            return (Criteria) this;
        }

        public Criteria andVaccineTimeLessThanOrEqualTo(Long value) {
            addCriterion("vaccine_time <=", value, "vaccineTime");
            return (Criteria) this;
        }

        public Criteria andVaccineTimeIn(List<Long> values) {
            addCriterion("vaccine_time in", values, "vaccineTime");
            return (Criteria) this;
        }

        public Criteria andVaccineTimeNotIn(List<Long> values) {
            addCriterion("vaccine_time not in", values, "vaccineTime");
            return (Criteria) this;
        }

        public Criteria andVaccineTimeBetween(Long value1, Long value2) {
            addCriterion("vaccine_time between", value1, value2, "vaccineTime");
            return (Criteria) this;
        }

        public Criteria andVaccineTimeNotBetween(Long value1, Long value2) {
            addCriterion("vaccine_time not between", value1, value2, "vaccineTime");
            return (Criteria) this;
        }

        public Criteria andPetTellIsNull() {
            addCriterion("pet_tell is null");
            return (Criteria) this;
        }

        public Criteria andPetTellIsNotNull() {
            addCriterion("pet_tell is not null");
            return (Criteria) this;
        }

        public Criteria andPetTellEqualTo(String value) {
            addCriterion("pet_tell =", value, "petTell");
            return (Criteria) this;
        }

        public Criteria andPetTellNotEqualTo(String value) {
            addCriterion("pet_tell <>", value, "petTell");
            return (Criteria) this;
        }

        public Criteria andPetTellGreaterThan(String value) {
            addCriterion("pet_tell >", value, "petTell");
            return (Criteria) this;
        }

        public Criteria andPetTellGreaterThanOrEqualTo(String value) {
            addCriterion("pet_tell >=", value, "petTell");
            return (Criteria) this;
        }

        public Criteria andPetTellLessThan(String value) {
            addCriterion("pet_tell <", value, "petTell");
            return (Criteria) this;
        }

        public Criteria andPetTellLessThanOrEqualTo(String value) {
            addCriterion("pet_tell <=", value, "petTell");
            return (Criteria) this;
        }

        public Criteria andPetTellLike(String value) {
            addCriterion("pet_tell like", value, "petTell");
            return (Criteria) this;
        }

        public Criteria andPetTellNotLike(String value) {
            addCriterion("pet_tell not like", value, "petTell");
            return (Criteria) this;
        }

        public Criteria andPetTellIn(List<String> values) {
            addCriterion("pet_tell in", values, "petTell");
            return (Criteria) this;
        }

        public Criteria andPetTellNotIn(List<String> values) {
            addCriterion("pet_tell not in", values, "petTell");
            return (Criteria) this;
        }

        public Criteria andPetTellBetween(String value1, String value2) {
            addCriterion("pet_tell between", value1, value2, "petTell");
            return (Criteria) this;
        }

        public Criteria andPetTellNotBetween(String value1, String value2) {
            addCriterion("pet_tell not between", value1, value2, "petTell");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsIsNull() {
            addCriterion("head_portraits is null");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsIsNotNull() {
            addCriterion("head_portraits is not null");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsEqualTo(String value) {
            addCriterion("head_portraits =", value, "headPortraits");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsNotEqualTo(String value) {
            addCriterion("head_portraits <>", value, "headPortraits");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsGreaterThan(String value) {
            addCriterion("head_portraits >", value, "headPortraits");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsGreaterThanOrEqualTo(String value) {
            addCriterion("head_portraits >=", value, "headPortraits");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsLessThan(String value) {
            addCriterion("head_portraits <", value, "headPortraits");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsLessThanOrEqualTo(String value) {
            addCriterion("head_portraits <=", value, "headPortraits");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsLike(String value) {
            addCriterion("head_portraits like", value, "headPortraits");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsNotLike(String value) {
            addCriterion("head_portraits not like", value, "headPortraits");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsIn(List<String> values) {
            addCriterion("head_portraits in", values, "headPortraits");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsNotIn(List<String> values) {
            addCriterion("head_portraits not in", values, "headPortraits");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsBetween(String value1, String value2) {
            addCriterion("head_portraits between", value1, value2, "headPortraits");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsNotBetween(String value1, String value2) {
            addCriterion("head_portraits not between", value1, value2, "headPortraits");
            return (Criteria) this;
        }

        public Criteria andBrowseCountIsNull() {
            addCriterion("browse_count is null");
            return (Criteria) this;
        }

        public Criteria andBrowseCountIsNotNull() {
            addCriterion("browse_count is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseCountEqualTo(Integer value) {
            addCriterion("browse_count =", value, "browseCount");
            return (Criteria) this;
        }

        public Criteria andBrowseCountNotEqualTo(Integer value) {
            addCriterion("browse_count <>", value, "browseCount");
            return (Criteria) this;
        }

        public Criteria andBrowseCountGreaterThan(Integer value) {
            addCriterion("browse_count >", value, "browseCount");
            return (Criteria) this;
        }

        public Criteria andBrowseCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse_count >=", value, "browseCount");
            return (Criteria) this;
        }

        public Criteria andBrowseCountLessThan(Integer value) {
            addCriterion("browse_count <", value, "browseCount");
            return (Criteria) this;
        }

        public Criteria andBrowseCountLessThanOrEqualTo(Integer value) {
            addCriterion("browse_count <=", value, "browseCount");
            return (Criteria) this;
        }

        public Criteria andBrowseCountIn(List<Integer> values) {
            addCriterion("browse_count in", values, "browseCount");
            return (Criteria) this;
        }

        public Criteria andBrowseCountNotIn(List<Integer> values) {
            addCriterion("browse_count not in", values, "browseCount");
            return (Criteria) this;
        }

        public Criteria andBrowseCountBetween(Integer value1, Integer value2) {
            addCriterion("browse_count between", value1, value2, "browseCount");
            return (Criteria) this;
        }

        public Criteria andBrowseCountNotBetween(Integer value1, Integer value2) {
            addCriterion("browse_count not between", value1, value2, "browseCount");
            return (Criteria) this;
        }

        public Criteria andPetStateIsNull() {
            addCriterion("pet_state is null");
            return (Criteria) this;
        }

        public Criteria andPetStateIsNotNull() {
            addCriterion("pet_state is not null");
            return (Criteria) this;
        }

        public Criteria andPetStateEqualTo(Byte value) {
            addCriterion("pet_state =", value, "petState");
            return (Criteria) this;
        }

        public Criteria andPetStateNotEqualTo(Byte value) {
            addCriterion("pet_state <>", value, "petState");
            return (Criteria) this;
        }

        public Criteria andPetStateGreaterThan(Byte value) {
            addCriterion("pet_state >", value, "petState");
            return (Criteria) this;
        }

        public Criteria andPetStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("pet_state >=", value, "petState");
            return (Criteria) this;
        }

        public Criteria andPetStateLessThan(Byte value) {
            addCriterion("pet_state <", value, "petState");
            return (Criteria) this;
        }

        public Criteria andPetStateLessThanOrEqualTo(Byte value) {
            addCriterion("pet_state <=", value, "petState");
            return (Criteria) this;
        }

        public Criteria andPetStateIn(List<Byte> values) {
            addCriterion("pet_state in", values, "petState");
            return (Criteria) this;
        }

        public Criteria andPetStateNotIn(List<Byte> values) {
            addCriterion("pet_state not in", values, "petState");
            return (Criteria) this;
        }

        public Criteria andPetStateBetween(Byte value1, Byte value2) {
            addCriterion("pet_state between", value1, value2, "petState");
            return (Criteria) this;
        }

        public Criteria andPetStateNotBetween(Byte value1, Byte value2) {
            addCriterion("pet_state not between", value1, value2, "petState");
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

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andBreedLikeInsensitive(String value) {
            addCriterion("upper(breed) like", value.toUpperCase(), "breed");
            return (Criteria) this;
        }

        public Criteria andLocationLikeInsensitive(String value) {
            addCriterion("upper(location) like", value.toUpperCase(), "location");
            return (Criteria) this;
        }

        public Criteria andPetTellLikeInsensitive(String value) {
            addCriterion("upper(pet_tell) like", value.toUpperCase(), "petTell");
            return (Criteria) this;
        }

        public Criteria andCommentLikeInsensitive(String value) {
            addCriterion("upper(comment) like", value.toUpperCase(), "comment");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitsLikeInsensitive(String value) {
            addCriterion("upper(head_portraits) like", value.toUpperCase(), "headPortraits");
            return (Criteria) this;
        }
    }

    /**
     * adopt_little_ped
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