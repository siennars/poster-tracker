import Teammate from './Teammate.js';

export default {
  name: 'App',
  components: {
    Teammate
  },
  template: `
    <div class="container mx-auto p-4">
      <h1>Poster Tracker All - Stars</h1>
      <Teammate></Teammate>
    </div>
  `,
};