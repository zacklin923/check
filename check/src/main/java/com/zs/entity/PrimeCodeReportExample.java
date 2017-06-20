package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrimeCodeReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrimeCodeReportExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCtmNameIsNull() {
            addCriterion("CTM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCtmNameIsNotNull() {
            addCriterion("CTM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCtmNameEqualTo(String value) {
            addCriterion("CTM_NAME =", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameNotEqualTo(String value) {
            addCriterion("CTM_NAME <>", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameGreaterThan(String value) {
            addCriterion("CTM_NAME >", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameGreaterThanOrEqualTo(String value) {
            addCriterion("CTM_NAME >=", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameLessThan(String value) {
            addCriterion("CTM_NAME <", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameLessThanOrEqualTo(String value) {
            addCriterion("CTM_NAME <=", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameLike(String value) {
            addCriterion("CTM_NAME like", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameNotLike(String value) {
            addCriterion("CTM_NAME not like", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameIn(List<String> values) {
            addCriterion("CTM_NAME in", values, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameNotIn(List<String> values) {
            addCriterion("CTM_NAME not in", values, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameBetween(String value1, String value2) {
            addCriterion("CTM_NAME between", value1, value2, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameNotBetween(String value1, String value2) {
            addCriterion("CTM_NAME not between", value1, value2, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeIsNull() {
            addCriterion("CTM_BAR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeIsNotNull() {
            addCriterion("CTM_BAR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeEqualTo(String value) {
            addCriterion("CTM_BAR_CODE =", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeNotEqualTo(String value) {
            addCriterion("CTM_BAR_CODE <>", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeGreaterThan(String value) {
            addCriterion("CTM_BAR_CODE >", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CTM_BAR_CODE >=", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeLessThan(String value) {
            addCriterion("CTM_BAR_CODE <", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeLessThanOrEqualTo(String value) {
            addCriterion("CTM_BAR_CODE <=", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeLike(String value) {
            addCriterion("CTM_BAR_CODE like", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeNotLike(String value) {
            addCriterion("CTM_BAR_CODE not like", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeIn(List<String> values) {
            addCriterion("CTM_BAR_CODE in", values, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeNotIn(List<String> values) {
            addCriterion("CTM_BAR_CODE not in", values, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeBetween(String value1, String value2) {
            addCriterion("CTM_BAR_CODE between", value1, value2, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeNotBetween(String value1, String value2) {
            addCriterion("CTM_BAR_CODE not between", value1, value2, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmTypeIsNull() {
            addCriterion("CTM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCtmTypeIsNotNull() {
            addCriterion("CTM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCtmTypeEqualTo(String value) {
            addCriterion("CTM_TYPE =", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeNotEqualTo(String value) {
            addCriterion("CTM_TYPE <>", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeGreaterThan(String value) {
            addCriterion("CTM_TYPE >", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CTM_TYPE >=", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeLessThan(String value) {
            addCriterion("CTM_TYPE <", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeLessThanOrEqualTo(String value) {
            addCriterion("CTM_TYPE <=", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeLike(String value) {
            addCriterion("CTM_TYPE like", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeNotLike(String value) {
            addCriterion("CTM_TYPE not like", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeIn(List<String> values) {
            addCriterion("CTM_TYPE in", values, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeNotIn(List<String> values) {
            addCriterion("CTM_TYPE not in", values, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeBetween(String value1, String value2) {
            addCriterion("CTM_TYPE between", value1, value2, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeNotBetween(String value1, String value2) {
            addCriterion("CTM_TYPE not between", value1, value2, "ctmType");
            return (Criteria) this;
        }

        public Criteria andLargeAreaIsNull() {
            addCriterion("LARGE_AREA is null");
            return (Criteria) this;
        }

        public Criteria andLargeAreaIsNotNull() {
            addCriterion("LARGE_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andLargeAreaEqualTo(String value) {
            addCriterion("LARGE_AREA =", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaNotEqualTo(String value) {
            addCriterion("LARGE_AREA <>", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaGreaterThan(String value) {
            addCriterion("LARGE_AREA >", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaGreaterThanOrEqualTo(String value) {
            addCriterion("LARGE_AREA >=", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaLessThan(String value) {
            addCriterion("LARGE_AREA <", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaLessThanOrEqualTo(String value) {
            addCriterion("LARGE_AREA <=", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaLike(String value) {
            addCriterion("LARGE_AREA like", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaNotLike(String value) {
            addCriterion("LARGE_AREA not like", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaIn(List<String> values) {
            addCriterion("LARGE_AREA in", values, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaNotIn(List<String> values) {
            addCriterion("LARGE_AREA not in", values, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaBetween(String value1, String value2) {
            addCriterion("LARGE_AREA between", value1, value2, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaNotBetween(String value1, String value2) {
            addCriterion("LARGE_AREA not between", value1, value2, "largeArea");
            return (Criteria) this;
        }

        public Criteria andCountJdIsNull() {
            addCriterion("COUNT_JD is null");
            return (Criteria) this;
        }

        public Criteria andCountJdIsNotNull() {
            addCriterion("COUNT_JD is not null");
            return (Criteria) this;
        }

        public Criteria andCountJdEqualTo(BigDecimal value) {
            addCriterion("COUNT_JD =", value, "countJd");
            return (Criteria) this;
        }

        public Criteria andCountJdNotEqualTo(BigDecimal value) {
            addCriterion("COUNT_JD <>", value, "countJd");
            return (Criteria) this;
        }

        public Criteria andCountJdGreaterThan(BigDecimal value) {
            addCriterion("COUNT_JD >", value, "countJd");
            return (Criteria) this;
        }

        public Criteria andCountJdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_JD >=", value, "countJd");
            return (Criteria) this;
        }

        public Criteria andCountJdLessThan(BigDecimal value) {
            addCriterion("COUNT_JD <", value, "countJd");
            return (Criteria) this;
        }

        public Criteria andCountJdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_JD <=", value, "countJd");
            return (Criteria) this;
        }

        public Criteria andCountJdIn(List<BigDecimal> values) {
            addCriterion("COUNT_JD in", values, "countJd");
            return (Criteria) this;
        }

        public Criteria andCountJdNotIn(List<BigDecimal> values) {
            addCriterion("COUNT_JD not in", values, "countJd");
            return (Criteria) this;
        }

        public Criteria andCountJdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_JD between", value1, value2, "countJd");
            return (Criteria) this;
        }

        public Criteria andCountJdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_JD not between", value1, value2, "countJd");
            return (Criteria) this;
        }

        public Criteria andHourJdIsNull() {
            addCriterion("HOUR_JD is null");
            return (Criteria) this;
        }

        public Criteria andHourJdIsNotNull() {
            addCriterion("HOUR_JD is not null");
            return (Criteria) this;
        }

        public Criteria andHourJdEqualTo(BigDecimal value) {
            addCriterion("HOUR_JD =", value, "hourJd");
            return (Criteria) this;
        }

        public Criteria andHourJdNotEqualTo(BigDecimal value) {
            addCriterion("HOUR_JD <>", value, "hourJd");
            return (Criteria) this;
        }

        public Criteria andHourJdGreaterThan(BigDecimal value) {
            addCriterion("HOUR_JD >", value, "hourJd");
            return (Criteria) this;
        }

        public Criteria andHourJdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_JD >=", value, "hourJd");
            return (Criteria) this;
        }

        public Criteria andHourJdLessThan(BigDecimal value) {
            addCriterion("HOUR_JD <", value, "hourJd");
            return (Criteria) this;
        }

        public Criteria andHourJdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_JD <=", value, "hourJd");
            return (Criteria) this;
        }

        public Criteria andHourJdIn(List<BigDecimal> values) {
            addCriterion("HOUR_JD in", values, "hourJd");
            return (Criteria) this;
        }

        public Criteria andHourJdNotIn(List<BigDecimal> values) {
            addCriterion("HOUR_JD not in", values, "hourJd");
            return (Criteria) this;
        }

        public Criteria andHourJdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_JD between", value1, value2, "hourJd");
            return (Criteria) this;
        }

        public Criteria andHourJdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_JD not between", value1, value2, "hourJd");
            return (Criteria) this;
        }

        public Criteria andCountCjIsNull() {
            addCriterion("COUNT_CJ is null");
            return (Criteria) this;
        }

        public Criteria andCountCjIsNotNull() {
            addCriterion("COUNT_CJ is not null");
            return (Criteria) this;
        }

        public Criteria andCountCjEqualTo(BigDecimal value) {
            addCriterion("COUNT_CJ =", value, "countCj");
            return (Criteria) this;
        }

        public Criteria andCountCjNotEqualTo(BigDecimal value) {
            addCriterion("COUNT_CJ <>", value, "countCj");
            return (Criteria) this;
        }

        public Criteria andCountCjGreaterThan(BigDecimal value) {
            addCriterion("COUNT_CJ >", value, "countCj");
            return (Criteria) this;
        }

        public Criteria andCountCjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_CJ >=", value, "countCj");
            return (Criteria) this;
        }

        public Criteria andCountCjLessThan(BigDecimal value) {
            addCriterion("COUNT_CJ <", value, "countCj");
            return (Criteria) this;
        }

        public Criteria andCountCjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_CJ <=", value, "countCj");
            return (Criteria) this;
        }

        public Criteria andCountCjIn(List<BigDecimal> values) {
            addCriterion("COUNT_CJ in", values, "countCj");
            return (Criteria) this;
        }

        public Criteria andCountCjNotIn(List<BigDecimal> values) {
            addCriterion("COUNT_CJ not in", values, "countCj");
            return (Criteria) this;
        }

        public Criteria andCountCjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_CJ between", value1, value2, "countCj");
            return (Criteria) this;
        }

        public Criteria andCountCjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_CJ not between", value1, value2, "countCj");
            return (Criteria) this;
        }

        public Criteria andHourCjIsNull() {
            addCriterion("HOUR_CJ is null");
            return (Criteria) this;
        }

        public Criteria andHourCjIsNotNull() {
            addCriterion("HOUR_CJ is not null");
            return (Criteria) this;
        }

        public Criteria andHourCjEqualTo(BigDecimal value) {
            addCriterion("HOUR_CJ =", value, "hourCj");
            return (Criteria) this;
        }

        public Criteria andHourCjNotEqualTo(BigDecimal value) {
            addCriterion("HOUR_CJ <>", value, "hourCj");
            return (Criteria) this;
        }

        public Criteria andHourCjGreaterThan(BigDecimal value) {
            addCriterion("HOUR_CJ >", value, "hourCj");
            return (Criteria) this;
        }

        public Criteria andHourCjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_CJ >=", value, "hourCj");
            return (Criteria) this;
        }

        public Criteria andHourCjLessThan(BigDecimal value) {
            addCriterion("HOUR_CJ <", value, "hourCj");
            return (Criteria) this;
        }

        public Criteria andHourCjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_CJ <=", value, "hourCj");
            return (Criteria) this;
        }

        public Criteria andHourCjIn(List<BigDecimal> values) {
            addCriterion("HOUR_CJ in", values, "hourCj");
            return (Criteria) this;
        }

        public Criteria andHourCjNotIn(List<BigDecimal> values) {
            addCriterion("HOUR_CJ not in", values, "hourCj");
            return (Criteria) this;
        }

        public Criteria andHourCjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_CJ between", value1, value2, "hourCj");
            return (Criteria) this;
        }

        public Criteria andHourCjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_CJ not between", value1, value2, "hourCj");
            return (Criteria) this;
        }

        public Criteria andCountLyIsNull() {
            addCriterion("COUNT_LY is null");
            return (Criteria) this;
        }

        public Criteria andCountLyIsNotNull() {
            addCriterion("COUNT_LY is not null");
            return (Criteria) this;
        }

        public Criteria andCountLyEqualTo(BigDecimal value) {
            addCriterion("COUNT_LY =", value, "countLy");
            return (Criteria) this;
        }

        public Criteria andCountLyNotEqualTo(BigDecimal value) {
            addCriterion("COUNT_LY <>", value, "countLy");
            return (Criteria) this;
        }

        public Criteria andCountLyGreaterThan(BigDecimal value) {
            addCriterion("COUNT_LY >", value, "countLy");
            return (Criteria) this;
        }

        public Criteria andCountLyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_LY >=", value, "countLy");
            return (Criteria) this;
        }

        public Criteria andCountLyLessThan(BigDecimal value) {
            addCriterion("COUNT_LY <", value, "countLy");
            return (Criteria) this;
        }

        public Criteria andCountLyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_LY <=", value, "countLy");
            return (Criteria) this;
        }

        public Criteria andCountLyIn(List<BigDecimal> values) {
            addCriterion("COUNT_LY in", values, "countLy");
            return (Criteria) this;
        }

        public Criteria andCountLyNotIn(List<BigDecimal> values) {
            addCriterion("COUNT_LY not in", values, "countLy");
            return (Criteria) this;
        }

        public Criteria andCountLyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_LY between", value1, value2, "countLy");
            return (Criteria) this;
        }

        public Criteria andCountLyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_LY not between", value1, value2, "countLy");
            return (Criteria) this;
        }

        public Criteria andHourLyIsNull() {
            addCriterion("HOUR_LY is null");
            return (Criteria) this;
        }

        public Criteria andHourLyIsNotNull() {
            addCriterion("HOUR_LY is not null");
            return (Criteria) this;
        }

        public Criteria andHourLyEqualTo(BigDecimal value) {
            addCriterion("HOUR_LY =", value, "hourLy");
            return (Criteria) this;
        }

        public Criteria andHourLyNotEqualTo(BigDecimal value) {
            addCriterion("HOUR_LY <>", value, "hourLy");
            return (Criteria) this;
        }

        public Criteria andHourLyGreaterThan(BigDecimal value) {
            addCriterion("HOUR_LY >", value, "hourLy");
            return (Criteria) this;
        }

        public Criteria andHourLyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_LY >=", value, "hourLy");
            return (Criteria) this;
        }

        public Criteria andHourLyLessThan(BigDecimal value) {
            addCriterion("HOUR_LY <", value, "hourLy");
            return (Criteria) this;
        }

        public Criteria andHourLyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_LY <=", value, "hourLy");
            return (Criteria) this;
        }

        public Criteria andHourLyIn(List<BigDecimal> values) {
            addCriterion("HOUR_LY in", values, "hourLy");
            return (Criteria) this;
        }

        public Criteria andHourLyNotIn(List<BigDecimal> values) {
            addCriterion("HOUR_LY not in", values, "hourLy");
            return (Criteria) this;
        }

        public Criteria andHourLyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_LY between", value1, value2, "hourLy");
            return (Criteria) this;
        }

        public Criteria andHourLyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_LY not between", value1, value2, "hourLy");
            return (Criteria) this;
        }

        public Criteria andCountGdIsNull() {
            addCriterion("COUNT_GD is null");
            return (Criteria) this;
        }

        public Criteria andCountGdIsNotNull() {
            addCriterion("COUNT_GD is not null");
            return (Criteria) this;
        }

        public Criteria andCountGdEqualTo(BigDecimal value) {
            addCriterion("COUNT_GD =", value, "countGd");
            return (Criteria) this;
        }

        public Criteria andCountGdNotEqualTo(BigDecimal value) {
            addCriterion("COUNT_GD <>", value, "countGd");
            return (Criteria) this;
        }

        public Criteria andCountGdGreaterThan(BigDecimal value) {
            addCriterion("COUNT_GD >", value, "countGd");
            return (Criteria) this;
        }

        public Criteria andCountGdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_GD >=", value, "countGd");
            return (Criteria) this;
        }

        public Criteria andCountGdLessThan(BigDecimal value) {
            addCriterion("COUNT_GD <", value, "countGd");
            return (Criteria) this;
        }

        public Criteria andCountGdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_GD <=", value, "countGd");
            return (Criteria) this;
        }

        public Criteria andCountGdIn(List<BigDecimal> values) {
            addCriterion("COUNT_GD in", values, "countGd");
            return (Criteria) this;
        }

        public Criteria andCountGdNotIn(List<BigDecimal> values) {
            addCriterion("COUNT_GD not in", values, "countGd");
            return (Criteria) this;
        }

        public Criteria andCountGdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_GD between", value1, value2, "countGd");
            return (Criteria) this;
        }

        public Criteria andCountGdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_GD not between", value1, value2, "countGd");
            return (Criteria) this;
        }

        public Criteria andHourGdIsNull() {
            addCriterion("HOUR_GD is null");
            return (Criteria) this;
        }

        public Criteria andHourGdIsNotNull() {
            addCriterion("HOUR_GD is not null");
            return (Criteria) this;
        }

        public Criteria andHourGdEqualTo(BigDecimal value) {
            addCriterion("HOUR_GD =", value, "hourGd");
            return (Criteria) this;
        }

        public Criteria andHourGdNotEqualTo(BigDecimal value) {
            addCriterion("HOUR_GD <>", value, "hourGd");
            return (Criteria) this;
        }

        public Criteria andHourGdGreaterThan(BigDecimal value) {
            addCriterion("HOUR_GD >", value, "hourGd");
            return (Criteria) this;
        }

        public Criteria andHourGdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_GD >=", value, "hourGd");
            return (Criteria) this;
        }

        public Criteria andHourGdLessThan(BigDecimal value) {
            addCriterion("HOUR_GD <", value, "hourGd");
            return (Criteria) this;
        }

        public Criteria andHourGdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_GD <=", value, "hourGd");
            return (Criteria) this;
        }

        public Criteria andHourGdIn(List<BigDecimal> values) {
            addCriterion("HOUR_GD in", values, "hourGd");
            return (Criteria) this;
        }

        public Criteria andHourGdNotIn(List<BigDecimal> values) {
            addCriterion("HOUR_GD not in", values, "hourGd");
            return (Criteria) this;
        }

        public Criteria andHourGdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_GD between", value1, value2, "hourGd");
            return (Criteria) this;
        }

        public Criteria andHourGdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_GD not between", value1, value2, "hourGd");
            return (Criteria) this;
        }

        public Criteria andCountLpclIsNull() {
            addCriterion("COUNT_LPCL is null");
            return (Criteria) this;
        }

        public Criteria andCountLpclIsNotNull() {
            addCriterion("COUNT_LPCL is not null");
            return (Criteria) this;
        }

        public Criteria andCountLpclEqualTo(BigDecimal value) {
            addCriterion("COUNT_LPCL =", value, "countLpcl");
            return (Criteria) this;
        }

        public Criteria andCountLpclNotEqualTo(BigDecimal value) {
            addCriterion("COUNT_LPCL <>", value, "countLpcl");
            return (Criteria) this;
        }

        public Criteria andCountLpclGreaterThan(BigDecimal value) {
            addCriterion("COUNT_LPCL >", value, "countLpcl");
            return (Criteria) this;
        }

        public Criteria andCountLpclGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_LPCL >=", value, "countLpcl");
            return (Criteria) this;
        }

        public Criteria andCountLpclLessThan(BigDecimal value) {
            addCriterion("COUNT_LPCL <", value, "countLpcl");
            return (Criteria) this;
        }

        public Criteria andCountLpclLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_LPCL <=", value, "countLpcl");
            return (Criteria) this;
        }

        public Criteria andCountLpclIn(List<BigDecimal> values) {
            addCriterion("COUNT_LPCL in", values, "countLpcl");
            return (Criteria) this;
        }

        public Criteria andCountLpclNotIn(List<BigDecimal> values) {
            addCriterion("COUNT_LPCL not in", values, "countLpcl");
            return (Criteria) this;
        }

        public Criteria andCountLpclBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_LPCL between", value1, value2, "countLpcl");
            return (Criteria) this;
        }

        public Criteria andCountLpclNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_LPCL not between", value1, value2, "countLpcl");
            return (Criteria) this;
        }

        public Criteria andHourLpclIsNull() {
            addCriterion("HOUR_LPCL is null");
            return (Criteria) this;
        }

        public Criteria andHourLpclIsNotNull() {
            addCriterion("HOUR_LPCL is not null");
            return (Criteria) this;
        }

        public Criteria andHourLpclEqualTo(BigDecimal value) {
            addCriterion("HOUR_LPCL =", value, "hourLpcl");
            return (Criteria) this;
        }

        public Criteria andHourLpclNotEqualTo(BigDecimal value) {
            addCriterion("HOUR_LPCL <>", value, "hourLpcl");
            return (Criteria) this;
        }

        public Criteria andHourLpclGreaterThan(BigDecimal value) {
            addCriterion("HOUR_LPCL >", value, "hourLpcl");
            return (Criteria) this;
        }

        public Criteria andHourLpclGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_LPCL >=", value, "hourLpcl");
            return (Criteria) this;
        }

        public Criteria andHourLpclLessThan(BigDecimal value) {
            addCriterion("HOUR_LPCL <", value, "hourLpcl");
            return (Criteria) this;
        }

        public Criteria andHourLpclLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_LPCL <=", value, "hourLpcl");
            return (Criteria) this;
        }

        public Criteria andHourLpclIn(List<BigDecimal> values) {
            addCriterion("HOUR_LPCL in", values, "hourLpcl");
            return (Criteria) this;
        }

        public Criteria andHourLpclNotIn(List<BigDecimal> values) {
            addCriterion("HOUR_LPCL not in", values, "hourLpcl");
            return (Criteria) this;
        }

        public Criteria andHourLpclBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_LPCL between", value1, value2, "hourLpcl");
            return (Criteria) this;
        }

        public Criteria andHourLpclNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_LPCL not between", value1, value2, "hourLpcl");
            return (Criteria) this;
        }

        public Criteria andCountKsclIsNull() {
            addCriterion("COUNT_KSCL is null");
            return (Criteria) this;
        }

        public Criteria andCountKsclIsNotNull() {
            addCriterion("COUNT_KSCL is not null");
            return (Criteria) this;
        }

        public Criteria andCountKsclEqualTo(BigDecimal value) {
            addCriterion("COUNT_KSCL =", value, "countKscl");
            return (Criteria) this;
        }

        public Criteria andCountKsclNotEqualTo(BigDecimal value) {
            addCriterion("COUNT_KSCL <>", value, "countKscl");
            return (Criteria) this;
        }

        public Criteria andCountKsclGreaterThan(BigDecimal value) {
            addCriterion("COUNT_KSCL >", value, "countKscl");
            return (Criteria) this;
        }

        public Criteria andCountKsclGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_KSCL >=", value, "countKscl");
            return (Criteria) this;
        }

        public Criteria andCountKsclLessThan(BigDecimal value) {
            addCriterion("COUNT_KSCL <", value, "countKscl");
            return (Criteria) this;
        }

        public Criteria andCountKsclLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_KSCL <=", value, "countKscl");
            return (Criteria) this;
        }

        public Criteria andCountKsclIn(List<BigDecimal> values) {
            addCriterion("COUNT_KSCL in", values, "countKscl");
            return (Criteria) this;
        }

        public Criteria andCountKsclNotIn(List<BigDecimal> values) {
            addCriterion("COUNT_KSCL not in", values, "countKscl");
            return (Criteria) this;
        }

        public Criteria andCountKsclBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_KSCL between", value1, value2, "countKscl");
            return (Criteria) this;
        }

        public Criteria andCountKsclNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_KSCL not between", value1, value2, "countKscl");
            return (Criteria) this;
        }

        public Criteria andHourKsclIsNull() {
            addCriterion("HOUR_KSCL is null");
            return (Criteria) this;
        }

        public Criteria andHourKsclIsNotNull() {
            addCriterion("HOUR_KSCL is not null");
            return (Criteria) this;
        }

        public Criteria andHourKsclEqualTo(BigDecimal value) {
            addCriterion("HOUR_KSCL =", value, "hourKscl");
            return (Criteria) this;
        }

        public Criteria andHourKsclNotEqualTo(BigDecimal value) {
            addCriterion("HOUR_KSCL <>", value, "hourKscl");
            return (Criteria) this;
        }

        public Criteria andHourKsclGreaterThan(BigDecimal value) {
            addCriterion("HOUR_KSCL >", value, "hourKscl");
            return (Criteria) this;
        }

        public Criteria andHourKsclGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_KSCL >=", value, "hourKscl");
            return (Criteria) this;
        }

        public Criteria andHourKsclLessThan(BigDecimal value) {
            addCriterion("HOUR_KSCL <", value, "hourKscl");
            return (Criteria) this;
        }

        public Criteria andHourKsclLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_KSCL <=", value, "hourKscl");
            return (Criteria) this;
        }

        public Criteria andHourKsclIn(List<BigDecimal> values) {
            addCriterion("HOUR_KSCL in", values, "hourKscl");
            return (Criteria) this;
        }

        public Criteria andHourKsclNotIn(List<BigDecimal> values) {
            addCriterion("HOUR_KSCL not in", values, "hourKscl");
            return (Criteria) this;
        }

        public Criteria andHourKsclBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_KSCL between", value1, value2, "hourKscl");
            return (Criteria) this;
        }

        public Criteria andHourKsclNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_KSCL not between", value1, value2, "hourKscl");
            return (Criteria) this;
        }

        public Criteria andCountQsbIsNull() {
            addCriterion("COUNT_QSB is null");
            return (Criteria) this;
        }

        public Criteria andCountQsbIsNotNull() {
            addCriterion("COUNT_QSB is not null");
            return (Criteria) this;
        }

        public Criteria andCountQsbEqualTo(BigDecimal value) {
            addCriterion("COUNT_QSB =", value, "countQsb");
            return (Criteria) this;
        }

        public Criteria andCountQsbNotEqualTo(BigDecimal value) {
            addCriterion("COUNT_QSB <>", value, "countQsb");
            return (Criteria) this;
        }

        public Criteria andCountQsbGreaterThan(BigDecimal value) {
            addCriterion("COUNT_QSB >", value, "countQsb");
            return (Criteria) this;
        }

        public Criteria andCountQsbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_QSB >=", value, "countQsb");
            return (Criteria) this;
        }

        public Criteria andCountQsbLessThan(BigDecimal value) {
            addCriterion("COUNT_QSB <", value, "countQsb");
            return (Criteria) this;
        }

        public Criteria andCountQsbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_QSB <=", value, "countQsb");
            return (Criteria) this;
        }

        public Criteria andCountQsbIn(List<BigDecimal> values) {
            addCriterion("COUNT_QSB in", values, "countQsb");
            return (Criteria) this;
        }

        public Criteria andCountQsbNotIn(List<BigDecimal> values) {
            addCriterion("COUNT_QSB not in", values, "countQsb");
            return (Criteria) this;
        }

        public Criteria andCountQsbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_QSB between", value1, value2, "countQsb");
            return (Criteria) this;
        }

        public Criteria andCountQsbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_QSB not between", value1, value2, "countQsb");
            return (Criteria) this;
        }

        public Criteria andHourQsbIsNull() {
            addCriterion("HOUR_QSB is null");
            return (Criteria) this;
        }

        public Criteria andHourQsbIsNotNull() {
            addCriterion("HOUR_QSB is not null");
            return (Criteria) this;
        }

        public Criteria andHourQsbEqualTo(BigDecimal value) {
            addCriterion("HOUR_QSB =", value, "hourQsb");
            return (Criteria) this;
        }

        public Criteria andHourQsbNotEqualTo(BigDecimal value) {
            addCriterion("HOUR_QSB <>", value, "hourQsb");
            return (Criteria) this;
        }

        public Criteria andHourQsbGreaterThan(BigDecimal value) {
            addCriterion("HOUR_QSB >", value, "hourQsb");
            return (Criteria) this;
        }

        public Criteria andHourQsbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_QSB >=", value, "hourQsb");
            return (Criteria) this;
        }

        public Criteria andHourQsbLessThan(BigDecimal value) {
            addCriterion("HOUR_QSB <", value, "hourQsb");
            return (Criteria) this;
        }

        public Criteria andHourQsbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_QSB <=", value, "hourQsb");
            return (Criteria) this;
        }

        public Criteria andHourQsbIn(List<BigDecimal> values) {
            addCriterion("HOUR_QSB in", values, "hourQsb");
            return (Criteria) this;
        }

        public Criteria andHourQsbNotIn(List<BigDecimal> values) {
            addCriterion("HOUR_QSB not in", values, "hourQsb");
            return (Criteria) this;
        }

        public Criteria andHourQsbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_QSB between", value1, value2, "hourQsb");
            return (Criteria) this;
        }

        public Criteria andHourQsbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_QSB not between", value1, value2, "hourQsb");
            return (Criteria) this;
        }

        public Criteria andCountTjclIsNull() {
            addCriterion("COUNT_TJCL is null");
            return (Criteria) this;
        }

        public Criteria andCountTjclIsNotNull() {
            addCriterion("COUNT_TJCL is not null");
            return (Criteria) this;
        }

        public Criteria andCountTjclEqualTo(BigDecimal value) {
            addCriterion("COUNT_TJCL =", value, "countTjcl");
            return (Criteria) this;
        }

        public Criteria andCountTjclNotEqualTo(BigDecimal value) {
            addCriterion("COUNT_TJCL <>", value, "countTjcl");
            return (Criteria) this;
        }

        public Criteria andCountTjclGreaterThan(BigDecimal value) {
            addCriterion("COUNT_TJCL >", value, "countTjcl");
            return (Criteria) this;
        }

        public Criteria andCountTjclGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_TJCL >=", value, "countTjcl");
            return (Criteria) this;
        }

        public Criteria andCountTjclLessThan(BigDecimal value) {
            addCriterion("COUNT_TJCL <", value, "countTjcl");
            return (Criteria) this;
        }

        public Criteria andCountTjclLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_TJCL <=", value, "countTjcl");
            return (Criteria) this;
        }

        public Criteria andCountTjclIn(List<BigDecimal> values) {
            addCriterion("COUNT_TJCL in", values, "countTjcl");
            return (Criteria) this;
        }

        public Criteria andCountTjclNotIn(List<BigDecimal> values) {
            addCriterion("COUNT_TJCL not in", values, "countTjcl");
            return (Criteria) this;
        }

        public Criteria andCountTjclBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_TJCL between", value1, value2, "countTjcl");
            return (Criteria) this;
        }

        public Criteria andCountTjclNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_TJCL not between", value1, value2, "countTjcl");
            return (Criteria) this;
        }

        public Criteria andHourTjclIsNull() {
            addCriterion("HOUR_TJCL is null");
            return (Criteria) this;
        }

        public Criteria andHourTjclIsNotNull() {
            addCriterion("HOUR_TJCL is not null");
            return (Criteria) this;
        }

        public Criteria andHourTjclEqualTo(BigDecimal value) {
            addCriterion("HOUR_TJCL =", value, "hourTjcl");
            return (Criteria) this;
        }

        public Criteria andHourTjclNotEqualTo(BigDecimal value) {
            addCriterion("HOUR_TJCL <>", value, "hourTjcl");
            return (Criteria) this;
        }

        public Criteria andHourTjclGreaterThan(BigDecimal value) {
            addCriterion("HOUR_TJCL >", value, "hourTjcl");
            return (Criteria) this;
        }

        public Criteria andHourTjclGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_TJCL >=", value, "hourTjcl");
            return (Criteria) this;
        }

        public Criteria andHourTjclLessThan(BigDecimal value) {
            addCriterion("HOUR_TJCL <", value, "hourTjcl");
            return (Criteria) this;
        }

        public Criteria andHourTjclLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_TJCL <=", value, "hourTjcl");
            return (Criteria) this;
        }

        public Criteria andHourTjclIn(List<BigDecimal> values) {
            addCriterion("HOUR_TJCL in", values, "hourTjcl");
            return (Criteria) this;
        }

        public Criteria andHourTjclNotIn(List<BigDecimal> values) {
            addCriterion("HOUR_TJCL not in", values, "hourTjcl");
            return (Criteria) this;
        }

        public Criteria andHourTjclBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_TJCL between", value1, value2, "hourTjcl");
            return (Criteria) this;
        }

        public Criteria andHourTjclNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_TJCL not between", value1, value2, "hourTjcl");
            return (Criteria) this;
        }

        public Criteria andCountSdIsNull() {
            addCriterion("COUNT_SD is null");
            return (Criteria) this;
        }

        public Criteria andCountSdIsNotNull() {
            addCriterion("COUNT_SD is not null");
            return (Criteria) this;
        }

        public Criteria andCountSdEqualTo(BigDecimal value) {
            addCriterion("COUNT_SD =", value, "countSd");
            return (Criteria) this;
        }

        public Criteria andCountSdNotEqualTo(BigDecimal value) {
            addCriterion("COUNT_SD <>", value, "countSd");
            return (Criteria) this;
        }

        public Criteria andCountSdGreaterThan(BigDecimal value) {
            addCriterion("COUNT_SD >", value, "countSd");
            return (Criteria) this;
        }

        public Criteria andCountSdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_SD >=", value, "countSd");
            return (Criteria) this;
        }

        public Criteria andCountSdLessThan(BigDecimal value) {
            addCriterion("COUNT_SD <", value, "countSd");
            return (Criteria) this;
        }

        public Criteria andCountSdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_SD <=", value, "countSd");
            return (Criteria) this;
        }

        public Criteria andCountSdIn(List<BigDecimal> values) {
            addCriterion("COUNT_SD in", values, "countSd");
            return (Criteria) this;
        }

        public Criteria andCountSdNotIn(List<BigDecimal> values) {
            addCriterion("COUNT_SD not in", values, "countSd");
            return (Criteria) this;
        }

        public Criteria andCountSdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_SD between", value1, value2, "countSd");
            return (Criteria) this;
        }

        public Criteria andCountSdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_SD not between", value1, value2, "countSd");
            return (Criteria) this;
        }

        public Criteria andHourSdIsNull() {
            addCriterion("HOUR_SD is null");
            return (Criteria) this;
        }

        public Criteria andHourSdIsNotNull() {
            addCriterion("HOUR_SD is not null");
            return (Criteria) this;
        }

        public Criteria andHourSdEqualTo(BigDecimal value) {
            addCriterion("HOUR_SD =", value, "hourSd");
            return (Criteria) this;
        }

        public Criteria andHourSdNotEqualTo(BigDecimal value) {
            addCriterion("HOUR_SD <>", value, "hourSd");
            return (Criteria) this;
        }

        public Criteria andHourSdGreaterThan(BigDecimal value) {
            addCriterion("HOUR_SD >", value, "hourSd");
            return (Criteria) this;
        }

        public Criteria andHourSdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_SD >=", value, "hourSd");
            return (Criteria) this;
        }

        public Criteria andHourSdLessThan(BigDecimal value) {
            addCriterion("HOUR_SD <", value, "hourSd");
            return (Criteria) this;
        }

        public Criteria andHourSdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_SD <=", value, "hourSd");
            return (Criteria) this;
        }

        public Criteria andHourSdIn(List<BigDecimal> values) {
            addCriterion("HOUR_SD in", values, "hourSd");
            return (Criteria) this;
        }

        public Criteria andHourSdNotIn(List<BigDecimal> values) {
            addCriterion("HOUR_SD not in", values, "hourSd");
            return (Criteria) this;
        }

        public Criteria andHourSdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_SD between", value1, value2, "hourSd");
            return (Criteria) this;
        }

        public Criteria andHourSdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_SD not between", value1, value2, "hourSd");
            return (Criteria) this;
        }

        public Criteria andCountDdIsNull() {
            addCriterion("COUNT_DD is null");
            return (Criteria) this;
        }

        public Criteria andCountDdIsNotNull() {
            addCriterion("COUNT_DD is not null");
            return (Criteria) this;
        }

        public Criteria andCountDdEqualTo(BigDecimal value) {
            addCriterion("COUNT_DD =", value, "countDd");
            return (Criteria) this;
        }

        public Criteria andCountDdNotEqualTo(BigDecimal value) {
            addCriterion("COUNT_DD <>", value, "countDd");
            return (Criteria) this;
        }

        public Criteria andCountDdGreaterThan(BigDecimal value) {
            addCriterion("COUNT_DD >", value, "countDd");
            return (Criteria) this;
        }

        public Criteria andCountDdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_DD >=", value, "countDd");
            return (Criteria) this;
        }

        public Criteria andCountDdLessThan(BigDecimal value) {
            addCriterion("COUNT_DD <", value, "countDd");
            return (Criteria) this;
        }

        public Criteria andCountDdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_DD <=", value, "countDd");
            return (Criteria) this;
        }

        public Criteria andCountDdIn(List<BigDecimal> values) {
            addCriterion("COUNT_DD in", values, "countDd");
            return (Criteria) this;
        }

        public Criteria andCountDdNotIn(List<BigDecimal> values) {
            addCriterion("COUNT_DD not in", values, "countDd");
            return (Criteria) this;
        }

        public Criteria andCountDdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_DD between", value1, value2, "countDd");
            return (Criteria) this;
        }

        public Criteria andCountDdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_DD not between", value1, value2, "countDd");
            return (Criteria) this;
        }

        public Criteria andHourDdIsNull() {
            addCriterion("HOUR_DD is null");
            return (Criteria) this;
        }

        public Criteria andHourDdIsNotNull() {
            addCriterion("HOUR_DD is not null");
            return (Criteria) this;
        }

        public Criteria andHourDdEqualTo(BigDecimal value) {
            addCriterion("HOUR_DD =", value, "hourDd");
            return (Criteria) this;
        }

        public Criteria andHourDdNotEqualTo(BigDecimal value) {
            addCriterion("HOUR_DD <>", value, "hourDd");
            return (Criteria) this;
        }

        public Criteria andHourDdGreaterThan(BigDecimal value) {
            addCriterion("HOUR_DD >", value, "hourDd");
            return (Criteria) this;
        }

        public Criteria andHourDdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_DD >=", value, "hourDd");
            return (Criteria) this;
        }

        public Criteria andHourDdLessThan(BigDecimal value) {
            addCriterion("HOUR_DD <", value, "hourDd");
            return (Criteria) this;
        }

        public Criteria andHourDdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_DD <=", value, "hourDd");
            return (Criteria) this;
        }

        public Criteria andHourDdIn(List<BigDecimal> values) {
            addCriterion("HOUR_DD in", values, "hourDd");
            return (Criteria) this;
        }

        public Criteria andHourDdNotIn(List<BigDecimal> values) {
            addCriterion("HOUR_DD not in", values, "hourDd");
            return (Criteria) this;
        }

        public Criteria andHourDdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_DD between", value1, value2, "hourDd");
            return (Criteria) this;
        }

        public Criteria andHourDdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_DD not between", value1, value2, "hourDd");
            return (Criteria) this;
        }

        public Criteria andDayCountIsNull() {
            addCriterion("DAY_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andDayCountIsNotNull() {
            addCriterion("DAY_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDayCountEqualTo(BigDecimal value) {
            addCriterion("DAY_COUNT =", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountNotEqualTo(BigDecimal value) {
            addCriterion("DAY_COUNT <>", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountGreaterThan(BigDecimal value) {
            addCriterion("DAY_COUNT >", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_COUNT >=", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountLessThan(BigDecimal value) {
            addCriterion("DAY_COUNT <", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_COUNT <=", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountIn(List<BigDecimal> values) {
            addCriterion("DAY_COUNT in", values, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountNotIn(List<BigDecimal> values) {
            addCriterion("DAY_COUNT not in", values, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_COUNT between", value1, value2, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_COUNT not between", value1, value2, "dayCount");
            return (Criteria) this;
        }

        public Criteria andStuNumIsNull() {
            addCriterion("STU_NUM is null");
            return (Criteria) this;
        }

        public Criteria andStuNumIsNotNull() {
            addCriterion("STU_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andStuNumEqualTo(String value) {
            addCriterion("STU_NUM =", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotEqualTo(String value) {
            addCriterion("STU_NUM <>", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumGreaterThan(String value) {
            addCriterion("STU_NUM >", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumGreaterThanOrEqualTo(String value) {
            addCriterion("STU_NUM >=", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumLessThan(String value) {
            addCriterion("STU_NUM <", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumLessThanOrEqualTo(String value) {
            addCriterion("STU_NUM <=", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumLike(String value) {
            addCriterion("STU_NUM like", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotLike(String value) {
            addCriterion("STU_NUM not like", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumIn(List<String> values) {
            addCriterion("STU_NUM in", values, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotIn(List<String> values) {
            addCriterion("STU_NUM not in", values, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumBetween(String value1, String value2) {
            addCriterion("STU_NUM between", value1, value2, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotBetween(String value1, String value2) {
            addCriterion("STU_NUM not between", value1, value2, "stuNum");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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