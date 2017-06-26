package com.zs.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModuleLineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModuleLineExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andModuleNameIsNull() {
            addCriterion("MODULE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andModuleNameIsNotNull() {
            addCriterion("MODULE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andModuleNameEqualTo(String value) {
            addCriterion("MODULE_NAME =", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotEqualTo(String value) {
            addCriterion("MODULE_NAME <>", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThan(String value) {
            addCriterion("MODULE_NAME >", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("MODULE_NAME >=", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThan(String value) {
            addCriterion("MODULE_NAME <", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThanOrEqualTo(String value) {
            addCriterion("MODULE_NAME <=", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLike(String value) {
            addCriterion("MODULE_NAME like", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotLike(String value) {
            addCriterion("MODULE_NAME not like", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameIn(List<String> values) {
            addCriterion("MODULE_NAME in", values, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotIn(List<String> values) {
            addCriterion("MODULE_NAME not in", values, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameBetween(String value1, String value2) {
            addCriterion("MODULE_NAME between", value1, value2, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotBetween(String value1, String value2) {
            addCriterion("MODULE_NAME not between", value1, value2, "moduleName");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andLineFieldIsNull() {
            addCriterion("LINE_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andLineFieldIsNotNull() {
            addCriterion("LINE_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andLineFieldEqualTo(String value) {
            addCriterion("LINE_FIELD =", value, "lineField");
            return (Criteria) this;
        }

        public Criteria andLineFieldNotEqualTo(String value) {
            addCriterion("LINE_FIELD <>", value, "lineField");
            return (Criteria) this;
        }

        public Criteria andLineFieldGreaterThan(String value) {
            addCriterion("LINE_FIELD >", value, "lineField");
            return (Criteria) this;
        }

        public Criteria andLineFieldGreaterThanOrEqualTo(String value) {
            addCriterion("LINE_FIELD >=", value, "lineField");
            return (Criteria) this;
        }

        public Criteria andLineFieldLessThan(String value) {
            addCriterion("LINE_FIELD <", value, "lineField");
            return (Criteria) this;
        }

        public Criteria andLineFieldLessThanOrEqualTo(String value) {
            addCriterion("LINE_FIELD <=", value, "lineField");
            return (Criteria) this;
        }

        public Criteria andLineFieldLike(String value) {
            addCriterion("LINE_FIELD like", value, "lineField");
            return (Criteria) this;
        }

        public Criteria andLineFieldNotLike(String value) {
            addCriterion("LINE_FIELD not like", value, "lineField");
            return (Criteria) this;
        }

        public Criteria andLineFieldIn(List<String> values) {
            addCriterion("LINE_FIELD in", values, "lineField");
            return (Criteria) this;
        }

        public Criteria andLineFieldNotIn(List<String> values) {
            addCriterion("LINE_FIELD not in", values, "lineField");
            return (Criteria) this;
        }

        public Criteria andLineFieldBetween(String value1, String value2) {
            addCriterion("LINE_FIELD between", value1, value2, "lineField");
            return (Criteria) this;
        }

        public Criteria andLineFieldNotBetween(String value1, String value2) {
            addCriterion("LINE_FIELD not between", value1, value2, "lineField");
            return (Criteria) this;
        }

        public Criteria andLineWidthIsNull() {
            addCriterion("LINE_WIDTH is null");
            return (Criteria) this;
        }

        public Criteria andLineWidthIsNotNull() {
            addCriterion("LINE_WIDTH is not null");
            return (Criteria) this;
        }

        public Criteria andLineWidthEqualTo(String value) {
            addCriterion("LINE_WIDTH =", value, "lineWidth");
            return (Criteria) this;
        }

        public Criteria andLineWidthNotEqualTo(String value) {
            addCriterion("LINE_WIDTH <>", value, "lineWidth");
            return (Criteria) this;
        }

        public Criteria andLineWidthGreaterThan(String value) {
            addCriterion("LINE_WIDTH >", value, "lineWidth");
            return (Criteria) this;
        }

        public Criteria andLineWidthGreaterThanOrEqualTo(String value) {
            addCriterion("LINE_WIDTH >=", value, "lineWidth");
            return (Criteria) this;
        }

        public Criteria andLineWidthLessThan(String value) {
            addCriterion("LINE_WIDTH <", value, "lineWidth");
            return (Criteria) this;
        }

        public Criteria andLineWidthLessThanOrEqualTo(String value) {
            addCriterion("LINE_WIDTH <=", value, "lineWidth");
            return (Criteria) this;
        }

        public Criteria andLineWidthLike(String value) {
            addCriterion("LINE_WIDTH like", value, "lineWidth");
            return (Criteria) this;
        }

        public Criteria andLineWidthNotLike(String value) {
            addCriterion("LINE_WIDTH not like", value, "lineWidth");
            return (Criteria) this;
        }

        public Criteria andLineWidthIn(List<String> values) {
            addCriterion("LINE_WIDTH in", values, "lineWidth");
            return (Criteria) this;
        }

        public Criteria andLineWidthNotIn(List<String> values) {
            addCriterion("LINE_WIDTH not in", values, "lineWidth");
            return (Criteria) this;
        }

        public Criteria andLineWidthBetween(String value1, String value2) {
            addCriterion("LINE_WIDTH between", value1, value2, "lineWidth");
            return (Criteria) this;
        }

        public Criteria andLineWidthNotBetween(String value1, String value2) {
            addCriterion("LINE_WIDTH not between", value1, value2, "lineWidth");
            return (Criteria) this;
        }

        public Criteria andFormatterIsNull() {
            addCriterion("FORMATTER is null");
            return (Criteria) this;
        }

        public Criteria andFormatterIsNotNull() {
            addCriterion("FORMATTER is not null");
            return (Criteria) this;
        }

        public Criteria andFormatterEqualTo(String value) {
            addCriterion("FORMATTER =", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterNotEqualTo(String value) {
            addCriterion("FORMATTER <>", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterGreaterThan(String value) {
            addCriterion("FORMATTER >", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterGreaterThanOrEqualTo(String value) {
            addCriterion("FORMATTER >=", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterLessThan(String value) {
            addCriterion("FORMATTER <", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterLessThanOrEqualTo(String value) {
            addCriterion("FORMATTER <=", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterLike(String value) {
            addCriterion("FORMATTER like", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterNotLike(String value) {
            addCriterion("FORMATTER not like", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterIn(List<String> values) {
            addCriterion("FORMATTER in", values, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterNotIn(List<String> values) {
            addCriterion("FORMATTER not in", values, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterBetween(String value1, String value2) {
            addCriterion("FORMATTER between", value1, value2, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterNotBetween(String value1, String value2) {
            addCriterion("FORMATTER not between", value1, value2, "formatter");
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

        public Criteria andSortableIsNull() {
            addCriterion("SORTABLE is null");
            return (Criteria) this;
        }

        public Criteria andSortableIsNotNull() {
            addCriterion("SORTABLE is not null");
            return (Criteria) this;
        }

        public Criteria andSortableEqualTo(String value) {
            addCriterion("SORTABLE =", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableNotEqualTo(String value) {
            addCriterion("SORTABLE <>", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableGreaterThan(String value) {
            addCriterion("SORTABLE >", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableGreaterThanOrEqualTo(String value) {
            addCriterion("SORTABLE >=", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableLessThan(String value) {
            addCriterion("SORTABLE <", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableLessThanOrEqualTo(String value) {
            addCriterion("SORTABLE <=", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableLike(String value) {
            addCriterion("SORTABLE like", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableNotLike(String value) {
            addCriterion("SORTABLE not like", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableIn(List<String> values) {
            addCriterion("SORTABLE in", values, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableNotIn(List<String> values) {
            addCriterion("SORTABLE not in", values, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableBetween(String value1, String value2) {
            addCriterion("SORTABLE between", value1, value2, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableNotBetween(String value1, String value2) {
            addCriterion("SORTABLE not between", value1, value2, "sortable");
            return (Criteria) this;
        }

        public Criteria andRowspanIsNull() {
            addCriterion("ROWSPAN is null");
            return (Criteria) this;
        }

        public Criteria andRowspanIsNotNull() {
            addCriterion("ROWSPAN is not null");
            return (Criteria) this;
        }

        public Criteria andRowspanEqualTo(String value) {
            addCriterion("ROWSPAN =", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanNotEqualTo(String value) {
            addCriterion("ROWSPAN <>", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanGreaterThan(String value) {
            addCriterion("ROWSPAN >", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanGreaterThanOrEqualTo(String value) {
            addCriterion("ROWSPAN >=", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanLessThan(String value) {
            addCriterion("ROWSPAN <", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanLessThanOrEqualTo(String value) {
            addCriterion("ROWSPAN <=", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanLike(String value) {
            addCriterion("ROWSPAN like", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanNotLike(String value) {
            addCriterion("ROWSPAN not like", value, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanIn(List<String> values) {
            addCriterion("ROWSPAN in", values, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanNotIn(List<String> values) {
            addCriterion("ROWSPAN not in", values, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanBetween(String value1, String value2) {
            addCriterion("ROWSPAN between", value1, value2, "rowspan");
            return (Criteria) this;
        }

        public Criteria andRowspanNotBetween(String value1, String value2) {
            addCriterion("ROWSPAN not between", value1, value2, "rowspan");
            return (Criteria) this;
        }

        public Criteria andColspanIsNull() {
            addCriterion("COLSPAN is null");
            return (Criteria) this;
        }

        public Criteria andColspanIsNotNull() {
            addCriterion("COLSPAN is not null");
            return (Criteria) this;
        }

        public Criteria andColspanEqualTo(String value) {
            addCriterion("COLSPAN =", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotEqualTo(String value) {
            addCriterion("COLSPAN <>", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanGreaterThan(String value) {
            addCriterion("COLSPAN >", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanGreaterThanOrEqualTo(String value) {
            addCriterion("COLSPAN >=", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanLessThan(String value) {
            addCriterion("COLSPAN <", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanLessThanOrEqualTo(String value) {
            addCriterion("COLSPAN <=", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanLike(String value) {
            addCriterion("COLSPAN like", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotLike(String value) {
            addCriterion("COLSPAN not like", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanIn(List<String> values) {
            addCriterion("COLSPAN in", values, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotIn(List<String> values) {
            addCriterion("COLSPAN not in", values, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanBetween(String value1, String value2) {
            addCriterion("COLSPAN between", value1, value2, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotBetween(String value1, String value2) {
            addCriterion("COLSPAN not between", value1, value2, "colspan");
            return (Criteria) this;
        }

        public Criteria andEditorIsNull() {
            addCriterion("EDITOR is null");
            return (Criteria) this;
        }

        public Criteria andEditorIsNotNull() {
            addCriterion("EDITOR is not null");
            return (Criteria) this;
        }

        public Criteria andEditorEqualTo(String value) {
            addCriterion("EDITOR =", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotEqualTo(String value) {
            addCriterion("EDITOR <>", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorGreaterThan(String value) {
            addCriterion("EDITOR >", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorGreaterThanOrEqualTo(String value) {
            addCriterion("EDITOR >=", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLessThan(String value) {
            addCriterion("EDITOR <", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLessThanOrEqualTo(String value) {
            addCriterion("EDITOR <=", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLike(String value) {
            addCriterion("EDITOR like", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotLike(String value) {
            addCriterion("EDITOR not like", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorIn(List<String> values) {
            addCriterion("EDITOR in", values, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotIn(List<String> values) {
            addCriterion("EDITOR not in", values, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorBetween(String value1, String value2) {
            addCriterion("EDITOR between", value1, value2, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotBetween(String value1, String value2) {
            addCriterion("EDITOR not between", value1, value2, "editor");
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