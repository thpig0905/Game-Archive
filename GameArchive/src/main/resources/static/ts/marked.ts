import * as marked from 'marked';

const body = `
# h1 header

Loren ipsum **test** area

[link](https://blog.itcode.dev)

![null](https://blog.itcode.dev/img/)

<span class="red">native html tag</span>
`;

// @ts-ignore
const result = marked(body);

console.log(result);