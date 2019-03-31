
export default {
    name: 'Teammate',
    template: `
        <ul>
            <li v-for="teammate in teammates" v-bind:key="teammate.id">           
            <span>{{teammate.name}}</span>
            <span>{{teammate.posterCount}}</span>
            </li>
        </ul>
    `,
    data: function () {
        return {
            teammates: [{
                id: '',
                name:'',
                posterCount: ''
            }]
        }
    },
    mounted () {
        this.getTeammates();
    },
    methods: {
        getTeammates: function () {
            axios.get("/api/v1/teammates/get")
            .then(response => (this.teammates = response.data)) 
            .catch(error => console.log(error))
        }
    }
}