local function expireAPI_15(keys,arg)
    local keys = keys[1]
    local expire = arg[1]
    local count = arg[2]

    if redis.call('exists',key) == 0 then
        redis.call('setex',key,expire,1)
        return true
    end

    if redis.call('get',key) >= count then
        return false
    end
    redis.call('incr',key)
    return true

end

redis.register_function('expireAPI_15',expireAPI_15)
-- eval()
function list