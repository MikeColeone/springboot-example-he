# springboot-examples
# Environment
# Introduce
# Update
- 使用 save 方法可以插入或更新数据，但它在更新时会根据实体的主键进行判断，而 @Modifying 注解则用于在自定义的查询中明确表示这是一个更新操作。通过 @Modifying，你可以执行更复杂的更新逻辑，例如批量更新或基于条件的更新，这在某些情况下比简单的 save 方法更灵活