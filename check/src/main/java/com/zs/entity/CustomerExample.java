package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        public Criteria andCteBarCodeIsNull() {
            addCriterion("CTE_BAR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeIsNotNull() {
            addCriterion("CTE_BAR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeEqualTo(String value) {
            addCriterion("CTE_BAR_CODE =", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeNotEqualTo(String value) {
            addCriterion("CTE_BAR_CODE <>", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeGreaterThan(String value) {
            addCriterion("CTE_BAR_CODE >", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CTE_BAR_CODE >=", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeLessThan(String value) {
            addCriterion("CTE_BAR_CODE <", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeLessThanOrEqualTo(String value) {
            addCriterion("CTE_BAR_CODE <=", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeLike(String value) {
            addCriterion("CTE_BAR_CODE like", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeNotLike(String value) {
            addCriterion("CTE_BAR_CODE not like", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeIn(List<String> values) {
            addCriterion("CTE_BAR_CODE in", values, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeNotIn(List<String> values) {
            addCriterion("CTE_BAR_CODE not in", values, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeBetween(String value1, String value2) {
            addCriterion("CTE_BAR_CODE between", value1, value2, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeNotBetween(String value1, String value2) {
            addCriterion("CTE_BAR_CODE not between", value1, value2, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andHistoryCountIsNull() {
            addCriterion("HISTORY_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andHistoryCountIsNotNull() {
            addCriterion("HISTORY_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryCountEqualTo(BigDecimal value) {
            addCriterion("HISTORY_COUNT =", value, "historyCount");
            return (Criteria) this;
        }

        public Criteria andHistoryCountNotEqualTo(BigDecimal value) {
            addCriterion("HISTORY_COUNT <>", value, "historyCount");
            return (Criteria) this;
        }

        public Criteria andHistoryCountGreaterThan(BigDecimal value) {
            addCriterion("HISTORY_COUNT >", value, "historyCount");
            return (Criteria) this;
        }

        public Criteria andHistoryCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HISTORY_COUNT >=", value, "historyCount");
            return (Criteria) this;
        }

        public Criteria andHistoryCountLessThan(BigDecimal value) {
            addCriterion("HISTORY_COUNT <", value, "historyCount");
            return (Criteria) this;
        }

        public Criteria andHistoryCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HISTORY_COUNT <=", value, "historyCount");
            return (Criteria) this;
        }

        public Criteria andHistoryCountIn(List<BigDecimal> values) {
            addCriterion("HISTORY_COUNT in", values, "historyCount");
            return (Criteria) this;
        }

        public Criteria andHistoryCountNotIn(List<BigDecimal> values) {
            addCriterion("HISTORY_COUNT not in", values, "historyCount");
            return (Criteria) this;
        }

        public Criteria andHistoryCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HISTORY_COUNT between", value1, value2, "historyCount");
            return (Criteria) this;
        }

        public Criteria andHistoryCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HISTORY_COUNT not between", value1, value2, "historyCount");
            return (Criteria) this;
        }

        public Criteria andCteNameIsNull() {
            addCriterion("CTE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCteNameIsNotNull() {
            addCriterion("CTE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCteNameEqualTo(String value) {
            addCriterion("CTE_NAME =", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameNotEqualTo(String value) {
            addCriterion("CTE_NAME <>", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameGreaterThan(String value) {
            addCriterion("CTE_NAME >", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameGreaterThanOrEqualTo(String value) {
            addCriterion("CTE_NAME >=", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameLessThan(String value) {
            addCriterion("CTE_NAME <", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameLessThanOrEqualTo(String value) {
            addCriterion("CTE_NAME <=", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameLike(String value) {
            addCriterion("CTE_NAME like", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameNotLike(String value) {
            addCriterion("CTE_NAME not like", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameIn(List<String> values) {
            addCriterion("CTE_NAME in", values, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameNotIn(List<String> values) {
            addCriterion("CTE_NAME not in", values, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameBetween(String value1, String value2) {
            addCriterion("CTE_NAME between", value1, value2, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameNotBetween(String value1, String value2) {
            addCriterion("CTE_NAME not between", value1, value2, "cteName");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterIsNull() {
            addCriterion("CUSTOM_SERVICE_CENTER is null");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterIsNotNull() {
            addCriterion("CUSTOM_SERVICE_CENTER is not null");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_CENTER =", value, "customServiceCenter");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterNotEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_CENTER <>", value, "customServiceCenter");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterGreaterThan(String value) {
            addCriterion("CUSTOM_SERVICE_CENTER >", value, "customServiceCenter");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_CENTER >=", value, "customServiceCenter");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterLessThan(String value) {
            addCriterion("CUSTOM_SERVICE_CENTER <", value, "customServiceCenter");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_CENTER <=", value, "customServiceCenter");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterLike(String value) {
            addCriterion("CUSTOM_SERVICE_CENTER like", value, "customServiceCenter");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterNotLike(String value) {
            addCriterion("CUSTOM_SERVICE_CENTER not like", value, "customServiceCenter");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterIn(List<String> values) {
            addCriterion("CUSTOM_SERVICE_CENTER in", values, "customServiceCenter");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterNotIn(List<String> values) {
            addCriterion("CUSTOM_SERVICE_CENTER not in", values, "customServiceCenter");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterBetween(String value1, String value2) {
            addCriterion("CUSTOM_SERVICE_CENTER between", value1, value2, "customServiceCenter");
            return (Criteria) this;
        }

        public Criteria andCustomServiceCenterNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_SERVICE_CENTER not between", value1, value2, "customServiceCenter");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopIsNull() {
            addCriterion("CUSTOM_SERVICE_TOP is null");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopIsNotNull() {
            addCriterion("CUSTOM_SERVICE_TOP is not null");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_TOP =", value, "customServiceTop");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopNotEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_TOP <>", value, "customServiceTop");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopGreaterThan(String value) {
            addCriterion("CUSTOM_SERVICE_TOP >", value, "customServiceTop");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_TOP >=", value, "customServiceTop");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopLessThan(String value) {
            addCriterion("CUSTOM_SERVICE_TOP <", value, "customServiceTop");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_TOP <=", value, "customServiceTop");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopLike(String value) {
            addCriterion("CUSTOM_SERVICE_TOP like", value, "customServiceTop");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopNotLike(String value) {
            addCriterion("CUSTOM_SERVICE_TOP not like", value, "customServiceTop");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopIn(List<String> values) {
            addCriterion("CUSTOM_SERVICE_TOP in", values, "customServiceTop");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopNotIn(List<String> values) {
            addCriterion("CUSTOM_SERVICE_TOP not in", values, "customServiceTop");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopBetween(String value1, String value2) {
            addCriterion("CUSTOM_SERVICE_TOP between", value1, value2, "customServiceTop");
            return (Criteria) this;
        }

        public Criteria andCustomServiceTopNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_SERVICE_TOP not between", value1, value2, "customServiceTop");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastIsNull() {
            addCriterion("CUSTOM_SERVICE_LAST is null");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastIsNotNull() {
            addCriterion("CUSTOM_SERVICE_LAST is not null");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_LAST =", value, "customServiceLast");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastNotEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_LAST <>", value, "customServiceLast");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastGreaterThan(String value) {
            addCriterion("CUSTOM_SERVICE_LAST >", value, "customServiceLast");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_LAST >=", value, "customServiceLast");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastLessThan(String value) {
            addCriterion("CUSTOM_SERVICE_LAST <", value, "customServiceLast");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_LAST <=", value, "customServiceLast");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastLike(String value) {
            addCriterion("CUSTOM_SERVICE_LAST like", value, "customServiceLast");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastNotLike(String value) {
            addCriterion("CUSTOM_SERVICE_LAST not like", value, "customServiceLast");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastIn(List<String> values) {
            addCriterion("CUSTOM_SERVICE_LAST in", values, "customServiceLast");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastNotIn(List<String> values) {
            addCriterion("CUSTOM_SERVICE_LAST not in", values, "customServiceLast");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastBetween(String value1, String value2) {
            addCriterion("CUSTOM_SERVICE_LAST between", value1, value2, "customServiceLast");
            return (Criteria) this;
        }

        public Criteria andCustomServiceLastNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_SERVICE_LAST not between", value1, value2, "customServiceLast");
            return (Criteria) this;
        }

        public Criteria andCustomTypeIsNull() {
            addCriterion("CUSTOM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCustomTypeIsNotNull() {
            addCriterion("CUSTOM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCustomTypeEqualTo(String value) {
            addCriterion("CUSTOM_TYPE =", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotEqualTo(String value) {
            addCriterion("CUSTOM_TYPE <>", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeGreaterThan(String value) {
            addCriterion("CUSTOM_TYPE >", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_TYPE >=", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeLessThan(String value) {
            addCriterion("CUSTOM_TYPE <", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_TYPE <=", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeLike(String value) {
            addCriterion("CUSTOM_TYPE like", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotLike(String value) {
            addCriterion("CUSTOM_TYPE not like", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeIn(List<String> values) {
            addCriterion("CUSTOM_TYPE in", values, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotIn(List<String> values) {
            addCriterion("CUSTOM_TYPE not in", values, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeBetween(String value1, String value2) {
            addCriterion("CUSTOM_TYPE between", value1, value2, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_TYPE not between", value1, value2, "customType");
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

        public Criteria andSliceAreaIsNull() {
            addCriterion("SLICE_AREA is null");
            return (Criteria) this;
        }

        public Criteria andSliceAreaIsNotNull() {
            addCriterion("SLICE_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andSliceAreaEqualTo(String value) {
            addCriterion("SLICE_AREA =", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaNotEqualTo(String value) {
            addCriterion("SLICE_AREA <>", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaGreaterThan(String value) {
            addCriterion("SLICE_AREA >", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaGreaterThanOrEqualTo(String value) {
            addCriterion("SLICE_AREA >=", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaLessThan(String value) {
            addCriterion("SLICE_AREA <", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaLessThanOrEqualTo(String value) {
            addCriterion("SLICE_AREA <=", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaLike(String value) {
            addCriterion("SLICE_AREA like", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaNotLike(String value) {
            addCriterion("SLICE_AREA not like", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaIn(List<String> values) {
            addCriterion("SLICE_AREA in", values, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaNotIn(List<String> values) {
            addCriterion("SLICE_AREA not in", values, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaBetween(String value1, String value2) {
            addCriterion("SLICE_AREA between", value1, value2, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaNotBetween(String value1, String value2) {
            addCriterion("SLICE_AREA not between", value1, value2, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andFenbuIsNull() {
            addCriterion("FENBU is null");
            return (Criteria) this;
        }

        public Criteria andFenbuIsNotNull() {
            addCriterion("FENBU is not null");
            return (Criteria) this;
        }

        public Criteria andFenbuEqualTo(String value) {
            addCriterion("FENBU =", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuNotEqualTo(String value) {
            addCriterion("FENBU <>", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuGreaterThan(String value) {
            addCriterion("FENBU >", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuGreaterThanOrEqualTo(String value) {
            addCriterion("FENBU >=", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuLessThan(String value) {
            addCriterion("FENBU <", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuLessThanOrEqualTo(String value) {
            addCriterion("FENBU <=", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuLike(String value) {
            addCriterion("FENBU like", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuNotLike(String value) {
            addCriterion("FENBU not like", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuIn(List<String> values) {
            addCriterion("FENBU in", values, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuNotIn(List<String> values) {
            addCriterion("FENBU not in", values, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuBetween(String value1, String value2) {
            addCriterion("FENBU between", value1, value2, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuNotBetween(String value1, String value2) {
            addCriterion("FENBU not between", value1, value2, "fenbu");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNull() {
            addCriterion("OPEN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNotNull() {
            addCriterion("OPEN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDateEqualTo(Date value) {
            addCriterion("OPEN_DATE =", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotEqualTo(Date value) {
            addCriterion("OPEN_DATE <>", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThan(Date value) {
            addCriterion("OPEN_DATE >", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThanOrEqualTo(Date value) {
            addCriterion("OPEN_DATE >=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThan(Date value) {
            addCriterion("OPEN_DATE <", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThanOrEqualTo(Date value) {
            addCriterion("OPEN_DATE <=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateIn(List<Date> values) {
            addCriterion("OPEN_DATE in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotIn(List<Date> values) {
            addCriterion("OPEN_DATE not in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateBetween(Date value1, Date value2) {
            addCriterion("OPEN_DATE between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotBetween(Date value1, Date value2) {
            addCriterion("OPEN_DATE not between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNull() {
            addCriterion("OUT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNotNull() {
            addCriterion("OUT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOutDateEqualTo(Date value) {
            addCriterion("OUT_DATE =", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotEqualTo(Date value) {
            addCriterion("OUT_DATE <>", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThan(Date value) {
            addCriterion("OUT_DATE >", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThanOrEqualTo(Date value) {
            addCriterion("OUT_DATE >=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThan(Date value) {
            addCriterion("OUT_DATE <", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThanOrEqualTo(Date value) {
            addCriterion("OUT_DATE <=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateIn(List<Date> values) {
            addCriterion("OUT_DATE in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotIn(List<Date> values) {
            addCriterion("OUT_DATE not in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateBetween(Date value1, Date value2) {
            addCriterion("OUT_DATE between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotBetween(Date value1, Date value2) {
            addCriterion("OUT_DATE not between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNull() {
            addCriterion("BUSINESS is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNotNull() {
            addCriterion("BUSINESS is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessEqualTo(String value) {
            addCriterion("BUSINESS =", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotEqualTo(String value) {
            addCriterion("BUSINESS <>", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThan(String value) {
            addCriterion("BUSINESS >", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS >=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThan(String value) {
            addCriterion("BUSINESS <", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS <=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLike(String value) {
            addCriterion("BUSINESS like", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotLike(String value) {
            addCriterion("BUSINESS not like", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessIn(List<String> values) {
            addCriterion("BUSINESS in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotIn(List<String> values) {
            addCriterion("BUSINESS not in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessBetween(String value1, String value2) {
            addCriterion("BUSINESS between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotBetween(String value1, String value2) {
            addCriterion("BUSINESS not between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeIsNull() {
            addCriterion("ACCOUNTS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeIsNotNull() {
            addCriterion("ACCOUNTS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeEqualTo(String value) {
            addCriterion("ACCOUNTS_TYPE =", value, "accountsType");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeNotEqualTo(String value) {
            addCriterion("ACCOUNTS_TYPE <>", value, "accountsType");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeGreaterThan(String value) {
            addCriterion("ACCOUNTS_TYPE >", value, "accountsType");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNTS_TYPE >=", value, "accountsType");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeLessThan(String value) {
            addCriterion("ACCOUNTS_TYPE <", value, "accountsType");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNTS_TYPE <=", value, "accountsType");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeLike(String value) {
            addCriterion("ACCOUNTS_TYPE like", value, "accountsType");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeNotLike(String value) {
            addCriterion("ACCOUNTS_TYPE not like", value, "accountsType");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeIn(List<String> values) {
            addCriterion("ACCOUNTS_TYPE in", values, "accountsType");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeNotIn(List<String> values) {
            addCriterion("ACCOUNTS_TYPE not in", values, "accountsType");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeBetween(String value1, String value2) {
            addCriterion("ACCOUNTS_TYPE between", value1, value2, "accountsType");
            return (Criteria) this;
        }

        public Criteria andAccountsTypeNotBetween(String value1, String value2) {
            addCriterion("ACCOUNTS_TYPE not between", value1, value2, "accountsType");
            return (Criteria) this;
        }

        public Criteria andPageTypeIsNull() {
            addCriterion("PAGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPageTypeIsNotNull() {
            addCriterion("PAGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPageTypeEqualTo(String value) {
            addCriterion("PAGE_TYPE =", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeNotEqualTo(String value) {
            addCriterion("PAGE_TYPE <>", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeGreaterThan(String value) {
            addCriterion("PAGE_TYPE >", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAGE_TYPE >=", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeLessThan(String value) {
            addCriterion("PAGE_TYPE <", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeLessThanOrEqualTo(String value) {
            addCriterion("PAGE_TYPE <=", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeLike(String value) {
            addCriterion("PAGE_TYPE like", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeNotLike(String value) {
            addCriterion("PAGE_TYPE not like", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeIn(List<String> values) {
            addCriterion("PAGE_TYPE in", values, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeNotIn(List<String> values) {
            addCriterion("PAGE_TYPE not in", values, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeBetween(String value1, String value2) {
            addCriterion("PAGE_TYPE between", value1, value2, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeNotBetween(String value1, String value2) {
            addCriterion("PAGE_TYPE not between", value1, value2, "pageType");
            return (Criteria) this;
        }

        public Criteria andDailyDeliveryIsNull() {
            addCriterion("DAILY_DELIVERY is null");
            return (Criteria) this;
        }

        public Criteria andDailyDeliveryIsNotNull() {
            addCriterion("DAILY_DELIVERY is not null");
            return (Criteria) this;
        }

        public Criteria andDailyDeliveryEqualTo(BigDecimal value) {
            addCriterion("DAILY_DELIVERY =", value, "dailyDelivery");
            return (Criteria) this;
        }

        public Criteria andDailyDeliveryNotEqualTo(BigDecimal value) {
            addCriterion("DAILY_DELIVERY <>", value, "dailyDelivery");
            return (Criteria) this;
        }

        public Criteria andDailyDeliveryGreaterThan(BigDecimal value) {
            addCriterion("DAILY_DELIVERY >", value, "dailyDelivery");
            return (Criteria) this;
        }

        public Criteria andDailyDeliveryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DAILY_DELIVERY >=", value, "dailyDelivery");
            return (Criteria) this;
        }

        public Criteria andDailyDeliveryLessThan(BigDecimal value) {
            addCriterion("DAILY_DELIVERY <", value, "dailyDelivery");
            return (Criteria) this;
        }

        public Criteria andDailyDeliveryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DAILY_DELIVERY <=", value, "dailyDelivery");
            return (Criteria) this;
        }

        public Criteria andDailyDeliveryIn(List<BigDecimal> values) {
            addCriterion("DAILY_DELIVERY in", values, "dailyDelivery");
            return (Criteria) this;
        }

        public Criteria andDailyDeliveryNotIn(List<BigDecimal> values) {
            addCriterion("DAILY_DELIVERY not in", values, "dailyDelivery");
            return (Criteria) this;
        }

        public Criteria andDailyDeliveryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAILY_DELIVERY between", value1, value2, "dailyDelivery");
            return (Criteria) this;
        }

        public Criteria andDailyDeliveryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAILY_DELIVERY not between", value1, value2, "dailyDelivery");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIsNull() {
            addCriterion("GOODS_DETAIL is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIsNotNull() {
            addCriterion("GOODS_DETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailEqualTo(String value) {
            addCriterion("GOODS_DETAIL =", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNotEqualTo(String value) {
            addCriterion("GOODS_DETAIL <>", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailGreaterThan(String value) {
            addCriterion("GOODS_DETAIL >", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_DETAIL >=", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailLessThan(String value) {
            addCriterion("GOODS_DETAIL <", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailLessThanOrEqualTo(String value) {
            addCriterion("GOODS_DETAIL <=", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailLike(String value) {
            addCriterion("GOODS_DETAIL like", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNotLike(String value) {
            addCriterion("GOODS_DETAIL not like", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIn(List<String> values) {
            addCriterion("GOODS_DETAIL in", values, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNotIn(List<String> values) {
            addCriterion("GOODS_DETAIL not in", values, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailBetween(String value1, String value2) {
            addCriterion("GOODS_DETAIL between", value1, value2, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNotBetween(String value1, String value2) {
            addCriterion("GOODS_DETAIL not between", value1, value2, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeIsNull() {
            addCriterion("CARRY_GOODS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeIsNotNull() {
            addCriterion("CARRY_GOODS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeEqualTo(String value) {
            addCriterion("CARRY_GOODS_TYPE =", value, "carryGoodsType");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeNotEqualTo(String value) {
            addCriterion("CARRY_GOODS_TYPE <>", value, "carryGoodsType");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeGreaterThan(String value) {
            addCriterion("CARRY_GOODS_TYPE >", value, "carryGoodsType");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CARRY_GOODS_TYPE >=", value, "carryGoodsType");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeLessThan(String value) {
            addCriterion("CARRY_GOODS_TYPE <", value, "carryGoodsType");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("CARRY_GOODS_TYPE <=", value, "carryGoodsType");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeLike(String value) {
            addCriterion("CARRY_GOODS_TYPE like", value, "carryGoodsType");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeNotLike(String value) {
            addCriterion("CARRY_GOODS_TYPE not like", value, "carryGoodsType");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeIn(List<String> values) {
            addCriterion("CARRY_GOODS_TYPE in", values, "carryGoodsType");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeNotIn(List<String> values) {
            addCriterion("CARRY_GOODS_TYPE not in", values, "carryGoodsType");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeBetween(String value1, String value2) {
            addCriterion("CARRY_GOODS_TYPE between", value1, value2, "carryGoodsType");
            return (Criteria) this;
        }

        public Criteria andCarryGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("CARRY_GOODS_TYPE not between", value1, value2, "carryGoodsType");
            return (Criteria) this;
        }

        public Criteria andPacketPointIsNull() {
            addCriterion("PACKET_POINT is null");
            return (Criteria) this;
        }

        public Criteria andPacketPointIsNotNull() {
            addCriterion("PACKET_POINT is not null");
            return (Criteria) this;
        }

        public Criteria andPacketPointEqualTo(String value) {
            addCriterion("PACKET_POINT =", value, "packetPoint");
            return (Criteria) this;
        }

        public Criteria andPacketPointNotEqualTo(String value) {
            addCriterion("PACKET_POINT <>", value, "packetPoint");
            return (Criteria) this;
        }

        public Criteria andPacketPointGreaterThan(String value) {
            addCriterion("PACKET_POINT >", value, "packetPoint");
            return (Criteria) this;
        }

        public Criteria andPacketPointGreaterThanOrEqualTo(String value) {
            addCriterion("PACKET_POINT >=", value, "packetPoint");
            return (Criteria) this;
        }

        public Criteria andPacketPointLessThan(String value) {
            addCriterion("PACKET_POINT <", value, "packetPoint");
            return (Criteria) this;
        }

        public Criteria andPacketPointLessThanOrEqualTo(String value) {
            addCriterion("PACKET_POINT <=", value, "packetPoint");
            return (Criteria) this;
        }

        public Criteria andPacketPointLike(String value) {
            addCriterion("PACKET_POINT like", value, "packetPoint");
            return (Criteria) this;
        }

        public Criteria andPacketPointNotLike(String value) {
            addCriterion("PACKET_POINT not like", value, "packetPoint");
            return (Criteria) this;
        }

        public Criteria andPacketPointIn(List<String> values) {
            addCriterion("PACKET_POINT in", values, "packetPoint");
            return (Criteria) this;
        }

        public Criteria andPacketPointNotIn(List<String> values) {
            addCriterion("PACKET_POINT not in", values, "packetPoint");
            return (Criteria) this;
        }

        public Criteria andPacketPointBetween(String value1, String value2) {
            addCriterion("PACKET_POINT between", value1, value2, "packetPoint");
            return (Criteria) this;
        }

        public Criteria andPacketPointNotBetween(String value1, String value2) {
            addCriterion("PACKET_POINT not between", value1, value2, "packetPoint");
            return (Criteria) this;
        }

        public Criteria andReturnPieceIsNull() {
            addCriterion("RETURN_PIECE is null");
            return (Criteria) this;
        }

        public Criteria andReturnPieceIsNotNull() {
            addCriterion("RETURN_PIECE is not null");
            return (Criteria) this;
        }

        public Criteria andReturnPieceEqualTo(String value) {
            addCriterion("RETURN_PIECE =", value, "returnPiece");
            return (Criteria) this;
        }

        public Criteria andReturnPieceNotEqualTo(String value) {
            addCriterion("RETURN_PIECE <>", value, "returnPiece");
            return (Criteria) this;
        }

        public Criteria andReturnPieceGreaterThan(String value) {
            addCriterion("RETURN_PIECE >", value, "returnPiece");
            return (Criteria) this;
        }

        public Criteria andReturnPieceGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_PIECE >=", value, "returnPiece");
            return (Criteria) this;
        }

        public Criteria andReturnPieceLessThan(String value) {
            addCriterion("RETURN_PIECE <", value, "returnPiece");
            return (Criteria) this;
        }

        public Criteria andReturnPieceLessThanOrEqualTo(String value) {
            addCriterion("RETURN_PIECE <=", value, "returnPiece");
            return (Criteria) this;
        }

        public Criteria andReturnPieceLike(String value) {
            addCriterion("RETURN_PIECE like", value, "returnPiece");
            return (Criteria) this;
        }

        public Criteria andReturnPieceNotLike(String value) {
            addCriterion("RETURN_PIECE not like", value, "returnPiece");
            return (Criteria) this;
        }

        public Criteria andReturnPieceIn(List<String> values) {
            addCriterion("RETURN_PIECE in", values, "returnPiece");
            return (Criteria) this;
        }

        public Criteria andReturnPieceNotIn(List<String> values) {
            addCriterion("RETURN_PIECE not in", values, "returnPiece");
            return (Criteria) this;
        }

        public Criteria andReturnPieceBetween(String value1, String value2) {
            addCriterion("RETURN_PIECE between", value1, value2, "returnPiece");
            return (Criteria) this;
        }

        public Criteria andReturnPieceNotBetween(String value1, String value2) {
            addCriterion("RETURN_PIECE not between", value1, value2, "returnPiece");
            return (Criteria) this;
        }

        public Criteria andMatterIsNull() {
            addCriterion("MATTER is null");
            return (Criteria) this;
        }

        public Criteria andMatterIsNotNull() {
            addCriterion("MATTER is not null");
            return (Criteria) this;
        }

        public Criteria andMatterEqualTo(String value) {
            addCriterion("MATTER =", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterNotEqualTo(String value) {
            addCriterion("MATTER <>", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterGreaterThan(String value) {
            addCriterion("MATTER >", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterGreaterThanOrEqualTo(String value) {
            addCriterion("MATTER >=", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterLessThan(String value) {
            addCriterion("MATTER <", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterLessThanOrEqualTo(String value) {
            addCriterion("MATTER <=", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterLike(String value) {
            addCriterion("MATTER like", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterNotLike(String value) {
            addCriterion("MATTER not like", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterIn(List<String> values) {
            addCriterion("MATTER in", values, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterNotIn(List<String> values) {
            addCriterion("MATTER not in", values, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterBetween(String value1, String value2) {
            addCriterion("MATTER between", value1, value2, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterNotBetween(String value1, String value2) {
            addCriterion("MATTER not between", value1, value2, "matter");
            return (Criteria) this;
        }

        public Criteria andComplainRebateIsNull() {
            addCriterion("COMPLAIN_REBATE is null");
            return (Criteria) this;
        }

        public Criteria andComplainRebateIsNotNull() {
            addCriterion("COMPLAIN_REBATE is not null");
            return (Criteria) this;
        }

        public Criteria andComplainRebateEqualTo(String value) {
            addCriterion("COMPLAIN_REBATE =", value, "complainRebate");
            return (Criteria) this;
        }

        public Criteria andComplainRebateNotEqualTo(String value) {
            addCriterion("COMPLAIN_REBATE <>", value, "complainRebate");
            return (Criteria) this;
        }

        public Criteria andComplainRebateGreaterThan(String value) {
            addCriterion("COMPLAIN_REBATE >", value, "complainRebate");
            return (Criteria) this;
        }

        public Criteria andComplainRebateGreaterThanOrEqualTo(String value) {
            addCriterion("COMPLAIN_REBATE >=", value, "complainRebate");
            return (Criteria) this;
        }

        public Criteria andComplainRebateLessThan(String value) {
            addCriterion("COMPLAIN_REBATE <", value, "complainRebate");
            return (Criteria) this;
        }

        public Criteria andComplainRebateLessThanOrEqualTo(String value) {
            addCriterion("COMPLAIN_REBATE <=", value, "complainRebate");
            return (Criteria) this;
        }

        public Criteria andComplainRebateLike(String value) {
            addCriterion("COMPLAIN_REBATE like", value, "complainRebate");
            return (Criteria) this;
        }

        public Criteria andComplainRebateNotLike(String value) {
            addCriterion("COMPLAIN_REBATE not like", value, "complainRebate");
            return (Criteria) this;
        }

        public Criteria andComplainRebateIn(List<String> values) {
            addCriterion("COMPLAIN_REBATE in", values, "complainRebate");
            return (Criteria) this;
        }

        public Criteria andComplainRebateNotIn(List<String> values) {
            addCriterion("COMPLAIN_REBATE not in", values, "complainRebate");
            return (Criteria) this;
        }

        public Criteria andComplainRebateBetween(String value1, String value2) {
            addCriterion("COMPLAIN_REBATE between", value1, value2, "complainRebate");
            return (Criteria) this;
        }

        public Criteria andComplainRebateNotBetween(String value1, String value2) {
            addCriterion("COMPLAIN_REBATE not between", value1, value2, "complainRebate");
            return (Criteria) this;
        }

        public Criteria andOptionFineIsNull() {
            addCriterion("OPTION_FINE is null");
            return (Criteria) this;
        }

        public Criteria andOptionFineIsNotNull() {
            addCriterion("OPTION_FINE is not null");
            return (Criteria) this;
        }

        public Criteria andOptionFineEqualTo(String value) {
            addCriterion("OPTION_FINE =", value, "optionFine");
            return (Criteria) this;
        }

        public Criteria andOptionFineNotEqualTo(String value) {
            addCriterion("OPTION_FINE <>", value, "optionFine");
            return (Criteria) this;
        }

        public Criteria andOptionFineGreaterThan(String value) {
            addCriterion("OPTION_FINE >", value, "optionFine");
            return (Criteria) this;
        }

        public Criteria andOptionFineGreaterThanOrEqualTo(String value) {
            addCriterion("OPTION_FINE >=", value, "optionFine");
            return (Criteria) this;
        }

        public Criteria andOptionFineLessThan(String value) {
            addCriterion("OPTION_FINE <", value, "optionFine");
            return (Criteria) this;
        }

        public Criteria andOptionFineLessThanOrEqualTo(String value) {
            addCriterion("OPTION_FINE <=", value, "optionFine");
            return (Criteria) this;
        }

        public Criteria andOptionFineLike(String value) {
            addCriterion("OPTION_FINE like", value, "optionFine");
            return (Criteria) this;
        }

        public Criteria andOptionFineNotLike(String value) {
            addCriterion("OPTION_FINE not like", value, "optionFine");
            return (Criteria) this;
        }

        public Criteria andOptionFineIn(List<String> values) {
            addCriterion("OPTION_FINE in", values, "optionFine");
            return (Criteria) this;
        }

        public Criteria andOptionFineNotIn(List<String> values) {
            addCriterion("OPTION_FINE not in", values, "optionFine");
            return (Criteria) this;
        }

        public Criteria andOptionFineBetween(String value1, String value2) {
            addCriterion("OPTION_FINE between", value1, value2, "optionFine");
            return (Criteria) this;
        }

        public Criteria andOptionFineNotBetween(String value1, String value2) {
            addCriterion("OPTION_FINE not between", value1, value2, "optionFine");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateIsNull() {
            addCriterion("FEE_COMPENSATE is null");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateIsNotNull() {
            addCriterion("FEE_COMPENSATE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateEqualTo(String value) {
            addCriterion("FEE_COMPENSATE =", value, "feeCompensate");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateNotEqualTo(String value) {
            addCriterion("FEE_COMPENSATE <>", value, "feeCompensate");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateGreaterThan(String value) {
            addCriterion("FEE_COMPENSATE >", value, "feeCompensate");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateGreaterThanOrEqualTo(String value) {
            addCriterion("FEE_COMPENSATE >=", value, "feeCompensate");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateLessThan(String value) {
            addCriterion("FEE_COMPENSATE <", value, "feeCompensate");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateLessThanOrEqualTo(String value) {
            addCriterion("FEE_COMPENSATE <=", value, "feeCompensate");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateLike(String value) {
            addCriterion("FEE_COMPENSATE like", value, "feeCompensate");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateNotLike(String value) {
            addCriterion("FEE_COMPENSATE not like", value, "feeCompensate");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateIn(List<String> values) {
            addCriterion("FEE_COMPENSATE in", values, "feeCompensate");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateNotIn(List<String> values) {
            addCriterion("FEE_COMPENSATE not in", values, "feeCompensate");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateBetween(String value1, String value2) {
            addCriterion("FEE_COMPENSATE between", value1, value2, "feeCompensate");
            return (Criteria) this;
        }

        public Criteria andFeeCompensateNotBetween(String value1, String value2) {
            addCriterion("FEE_COMPENSATE not between", value1, value2, "feeCompensate");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("NOTE is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("NOTE is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("NOTE =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("NOTE <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("NOTE >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("NOTE >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("NOTE <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("NOTE <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("NOTE like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("NOTE not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("NOTE in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("NOTE not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("NOTE between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("NOTE not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
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