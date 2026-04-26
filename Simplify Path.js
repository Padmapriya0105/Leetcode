var simplifyPath = function(path) {
    const stack = [];
    const components = path.split('/');

    for (const part of components) {
        if (part === '' || part === '.') {
            continue;
        }
        if (part === '..') {
            if (stack.length > 0) {
                stack.pop();
            }
        } else {
            stack.push(part);
        }
    }

    return '/' + stack.join('/');
};
